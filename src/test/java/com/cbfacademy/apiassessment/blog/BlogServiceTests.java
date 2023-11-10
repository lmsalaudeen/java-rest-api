package com.cbfacademy.apiassessment.blog;


import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertTrue;


import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("The BlogService class should: ")
public class BlogServiceTests {
    

    BlogService blogService = new BlogService(BlogStub.getBlogStub());

    @Test
    @DisplayName("return a list of blogs")
    public void findAllBlogsTest() {
        List<ContentManager> blogList = blogService.findAllBlogs();

        assertTrue(blogList.size() > 0);
    }

    @Test
    @DisplayName("return a blog by id")
    public void findBlogByIdTest() {
        Long id = 10L;
        ContentManager blog = blogService.findBlog(id);

        assertInstanceOf(Blog.class, blog);
    }

    @Test
    @DisplayName("create a blog")
    public void createBlogTest() {
        Blog newBlogStub = new Blog(10L, getInstant(), "NotLatifah", "Test title", "Test Content");
                
        blogService.createBlog(newBlogStub);

        assertInstanceOf(Blog.class, newBlogStub);
       
    }

    @Test
    @DisplayName("update a blog")
    public void updateBlogByIdTest() {
        
    }

    @Test
    @DisplayName("delete a blog")
    public void deleteBlogByIdTest() {
        
    }

    private Instant getInstant() {
		// Get the current date and time in the system's default time zone
		ZoneId systemTimeZone = ZoneId.systemDefault();
		ZonedDateTime currentDateTime = ZonedDateTime.now(systemTimeZone);

		// Convert to Instant
		Instant instant = currentDateTime.toInstant();

		return instant;
	}

}

