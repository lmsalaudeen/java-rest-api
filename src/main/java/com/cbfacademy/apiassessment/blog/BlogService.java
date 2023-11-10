package com.cbfacademy.apiassessment.blog;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BlogService {
    
    List<Blog> blog;

    public BlogService(List<Blog> blog){
        this.blog = blog;
    }

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

    public String deleteBlog(Long id) {
         for (Blog blog: this.blog) {
            if(blog.getId().equals(id)){ 
                this.blog.remove(blog);
                return "deleted";
            }
        } return null;
    }
}
