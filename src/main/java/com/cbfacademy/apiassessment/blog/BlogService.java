package com.cbfacademy.apiassessment.blog;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class BlogService {

    List<Blog> blog = new ArrayList<>(){
                { 
                    add(new Blog(1L, Instant.parse("2023-04-01T23:59:10.511Z"), "Latifah", "Blog Title 1", "Sample Text 1")); 
                    add(new Blog(2L, Instant.parse("2023-05-01T23:59:20.511Z"), "Mojisola", "Blog Title 2", "Sample Text 2"));
                    add(new Blog(3L, Instant.parse("2023-06-01T23:59:30.511Z"), "Salaudeen", "Blog Title 3", "Sample Text 3"));
    }
    }; 

    public List<Blog> findAllBlogs() {
        return this.blog;
    }

    public Blog findBlog(Long id) {
        for (Blog blog: this.blog)
            if(blog.getId().equals(id)){ 
                return blog;
            }
        return null;
    }

    public Blog createBlog(Blog blog) {
        Blog newBlog = new Blog(
                    blog.getId(),
                    blog.getDate(),
                    blog.getAuthor(),
                    blog.getTitle(),
                    blog.getContent()
        );
        this.blog.add(newBlog);
        return newBlog;
    }

    public Blog updateBlog(Long id, Blog updatedBlog) {
        // Only update a blog if it can be found first.
        for (Blog blog: this.blog) {
            if(blog.getId().equals(id)){ 
                blog.setId(updatedBlog.getId());
                blog.setDate(updatedBlog.getDate());
                blog.setAuthor(updatedBlog.getAuthor());
                blog.setTitle(updatedBlog.getTitle());
                blog.setContent(updatedBlog.getContent());

                return blog;
            }
        }
        return null;
    }

    public String delete(Long id) {
         for (Blog blog: this.blog) {
            if(blog.getId().equals(id)){ 
                this.blog.remove(blog);
            }
        }
        return null;
    }
}
