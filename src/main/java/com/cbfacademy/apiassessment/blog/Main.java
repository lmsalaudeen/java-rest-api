package com.cbfacademy.apiassessment.blog;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) {
		 // sample items
        List<Blog> sampleBlog = Arrays.asList(
                    new Blog(1L, Instant.parse("2023-04-01T23:59:10.511Z"), "Latifah", "Blog Title 1", "Sample Text 1"), 
                    new Blog(2L, Instant.parse("2023-05-01T23:59:20.511Z"), "Mojisola", "Blog Title 2", "Sample Text 2"),
                    new Blog(3L, Instant.parse("2023-06-01T23:59:30.511Z"), "Salaudeen", "Blog Title 3", "Sample Text 3")
                    );


        // JSONHandlerWithGSON.save(sampleBlog, "blogRepository.json");
        // System.out.println(sampleBlog);
        // List<Blog> blog = JSONHandlerWithGSON.readFile("blogRepository.json");
        List<ContentManager> blog = JSONHandler.read("blogRepository.json");
        System.out.println(blog);
        // JSONHandler.saveList(sampleBlog, "blogRepository.json");
    }
}
