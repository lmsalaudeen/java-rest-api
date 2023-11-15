package com.cbfacademy.apiassessment.blog;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.cbfacademy.apiassessment.algorithm.Algorithm;


public class Main {
    public static void main(String[] args) {
		 // sample items
        List<Blog> sampleBlog = new ArrayList<>(Arrays.asList(
                    new Blog(1L, Instant.parse("2023-07-01T23:59:10.511Z"), "Latifah", "Blog Title 1", "Sample Text 1"), 
                    new Blog(2L, Instant.parse("2023-05-01T23:59:20.511Z"), "Mojisola", "Blog Title 2", "Sample Text 2 with target"),
                    new Blog(3L, Instant.parse("2023-06-01T23:59:30.511Z"), "Salaudeen", "Blog Title 3", "Sample Text 3"),
                    new Blog(4L, Instant.parse("2023-03-01T23:59:10.511Z"), "NotLatifah", "Blog Title 4", "Sample Text 4 target"), 
                    new Blog(5L, Instant.parse("2023-02-01T23:59:20.511Z"), "NotMojisola", "Blog Title 5", "Sample Text 5 has target"),
                    new Blog(6L, Instant.parse("2023-01-01T23:59:30.511Z"), "NotSalaudeen", "Blog Title 6", "Sample Text 6")
                    ));
        List<Blog> sampleBlog2 = new ArrayList<>(Arrays.asList(
                    new Blog(1L, Instant.parse("2023-07-01T23:59:10.511Z"), "Latifah", "Blog Title 1", "Sample Text 1"), 
                    new Blog(2L, Instant.parse("2023-05-01T23:59:20.511Z"), "Mojisola", "Blog Title 2", "Sample Text 2")
                     ));
        Blog newBlogStub = new Blog(10L, Instant.parse("2022-04-01T23:59:10.511Z"), "NotLatifah", "Test title", "Test Content");

        
        // System.out.println(sampleBlog);
    //     List<Blog> blog = JSONHandler.read("blogRepository.json");
    //     System.out.println(blog);
    //     // JSONHandler.saveList(sampleBlog, "blogRepository.json");
    
    //     BlogService blogService = new BlogService(sampleBlog);
    //     blogService.deleteBlog(1L);

    //     System.out.println(blog);

    // algorithm check
    // System.out.println(Algorithm.searchBlogContent(sampleBlog, "tex"));
    // for (Blog blog: sampleBlog) {
    //     Long timestamp = blog.getDate().getEpochSecond();
    //     System.out.println(timestamp);
    // }

    List<Blog> searchList = Algorithm.searchBlogContent(sampleBlog, "target");

    System.out.println(searchList);
    Algorithm.mergeSortBlog(searchList);
    System.out.println(searchList);
    }
}
