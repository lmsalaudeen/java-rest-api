package com.cbfacademy.apiassessment.blog;

import java.net.URI;
import java.time.Instant;
import java.util.List;

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

    BlogService blogService = new BlogService();

    @GetMapping("/ping")
	public String ping() {
		return String.format("Service running successfully " + Instant.now().toString());
	}

    // get all blogs
    @GetMapping
    public ResponseEntity<List<Blog>> findAll() {
        List<Blog> blogs = blogService.findAllBlogs();
        return ResponseEntity.ok().body(blogs);
    }

    // get a blog using its id
    @GetMapping("/{id}")
    public ResponseEntity<Blog> find(@PathVariable("id") Long id) {
        Blog blog = blogService.findBlog(id);
        return ResponseEntity.ok(blog);
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
    public ResponseEntity<Blog> update(@PathVariable Long id, @RequestBody Blog updatedBlog){
        Blog updated = blogService.updateBlog(id, updatedBlog);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(updated.getId())
                .toUri();
        return ResponseEntity.created(location).body(updated);
    }

    // delete an item using an id parameter
    @DeleteMapping("/{id}")
    public ResponseEntity<Blog> delete(@PathVariable Long id){
        blogService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
