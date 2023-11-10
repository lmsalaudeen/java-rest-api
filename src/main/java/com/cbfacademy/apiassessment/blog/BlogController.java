package com.cbfacademy.apiassessment.blog;

import java.net.URI;
import java.time.Instant;
import java.util.ArrayList;
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

    // sample items
    List<ContentManager> sampleBlog = new ArrayList<>(){
                { 
                    add(new Blog(1L, Instant.parse("2023-04-01T23:59:10.511Z"), "Latifah", "Blog Title 1", "Sample Text 1")); 
                    add(new Blog(2L, Instant.parse("2023-05-01T23:59:20.511Z"), "Mojisola", "Blog Title 2", "Sample Text 2"));
                    add(new Blog(3L, Instant.parse("2023-06-01T23:59:30.511Z"), "Salaudeen", "Blog Title 3", "Sample Text 3"));
    }
    }; 

    // items from blogRepository.java
    List<ContentManager> blog = JSONHandler.read("blogRepository.json");
    
    BlogService blogService = new BlogService(sampleBlog);

    @GetMapping("/ping")
	public String ping() {
		return String.format("Service running successfully " + Instant.now().toString());
	}

    // get all blogs
    @GetMapping
    public ResponseEntity<List<ContentManager>> findAll() {
        List<ContentManager> blogs = blogService.findAllBlogs();
        return ResponseEntity.ok().body(blogs);
    }

    // get a blog using its id
    @GetMapping("/{id}")
    public ResponseEntity<ContentManager> find(@PathVariable("id") Long id) {
        ContentManager blog = blogService.findBlog(id);
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
        return ResponseEntity.created(location).body(created);
    }

    // update a blog
    @PutMapping("/{id}") // status report for errors
    public ResponseEntity<ContentManager> update(@PathVariable Long id, @RequestBody Blog updatedBlog){
        ContentManager updated = blogService.updateBlog(id, updatedBlog);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(updated.getId())
                .toUri();
        return ResponseEntity.created(location).body(updated);
    }

    // delete an item using an id parameter
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id){
        String deleted = blogService.delete(id);
        if (deleted != null) {
            return new ResponseEntity<>(HttpStatus.OK);
        } return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
