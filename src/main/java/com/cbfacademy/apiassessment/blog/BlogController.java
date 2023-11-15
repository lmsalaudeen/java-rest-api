package com.cbfacademy.apiassessment.blog;

import java.net.URI;
import java.time.Instant;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/blog")
public class BlogController {

     // items from blogRepository.java
    List<Blog> blogs = JSONHandler.read("blogRepository.json");
   
    BlogService blogService = new BlogService(blogs);

    @GetMapping("/ping")
	public String ping() {
		return String.format("Service running successfully " + Instant.now().toString());
	}

    // get all blogs
    @GetMapping("/blogs")
    public ResponseEntity<List<Blog>> findAll() {
        List<Blog> blogs = blogService.findAllBlogs();
        return ResponseEntity.ok().body(blogs);
    }

    // get a blog using its id
    @GetMapping("/{id}")
    public ResponseEntity<Blog> find(@PathVariable("id") Long id) {
        Blog blog = blogService.findBlog(id);
        if (blog != null) {
            return new ResponseEntity<>(blog, HttpStatus.FOUND);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // create a blog
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Blog> create(@RequestBody Blog blog) {
        Blog created = blogService.createBlog(blog);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();
        // then write back to file?
        JSONHandler.saveList(blogs, "blogRepository.json");
        return ResponseEntity.created(location).body(created);
    }

    // update a blog using an id parameter
    @PutMapping("/{id}") 
    public ResponseEntity<Blog> update(@PathVariable Long id, @RequestBody Blog updatedBlog){
        Blog updated = blogService.updateBlog(id, updatedBlog);
        // then write back to file
        JSONHandler.saveList(blogs, "blogRepository.json");

        return ResponseEntity.ok().body(updated);
    }

    // delete a blog using an id parameter
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id){
        String deleted = blogService.deleteBlog(id);
        if (deleted == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } 
        // then write back to file
        JSONHandler.saveList(blogs, "blogRepository.json");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // get blogs with keyword in content
    @GetMapping("/blogs/keyword={keyword}")
    public ResponseEntity<List<Blog>> findKeyword(@PathVariable("keyword") String keyword) {
        List<Blog> blogs = blogService.findBlogsWithKeyword(keyword);
        return ResponseEntity.ok().body(blogs);
    }

    // get Blogs by a particular author
    @GetMapping("/blogs/author={authorName}")
    public ResponseEntity<List<Blog>> findByAuthor(@PathVariable("authorName") String authorName) {
        List<Blog> blogs = blogService.findBlogsByAuthor(authorName);
        return ResponseEntity.ok().body(blogs);
    }

    // get all blogs ordered by date, asc (oldest post)
    @GetMapping("/blogs/orderByOldest")
    public ResponseEntity<List<Blog>> orderByOldest() {
        List<Blog> blogs = blogService.orderByOldest();
        return ResponseEntity.ok().body(blogs);
    }

    // get all blogs ordered by date, desc (latest post)
    @GetMapping("/blogs/orderByLatest")
    public ResponseEntity<List<Blog>> orderByLatest() {
        List<Blog> blogs = blogService.orderByLatest();
        return ResponseEntity.ok().body(blogs);
    }
}
