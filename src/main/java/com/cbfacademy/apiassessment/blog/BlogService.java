package com.cbfacademy.apiassessment.blog;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class BlogService {
    
    List<ContentManager> blog;

    public BlogService(List<ContentManager> blog){
        this.blog = blog;
    }

    public List<ContentManager> findAllBlogs() {
        return this.blog;
    }

    public ContentManager findBlog(Long id) {
        for (ContentManager blog: this.blog)
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

    public ContentManager updateBlog(Long id, Blog updatedBlog) {
        // Only update a blog if it can be found first.
        for (ContentManager blog: this.blog) {
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
         for (ContentManager blog: this.blog) {
            if(blog.getId().equals(id)){ 
                this.blog.remove(blog);
                return "deleted";
            }
        } return null;
    }
}
