package com.cbfacademy.apiassessment.algorithm;

import com.cbfacademy.apiassessment.blog.Blog;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class AlgorithmTest {
    // sample items
    List<Blog> sampleBlog = new ArrayList<>(Arrays.asList(
                new Blog(1L, Instant.parse("2023-07-01T23:59:10.511Z"), "Latifah", "Blog Title 1", "Sample Text 1"), 
                new Blog(2L, Instant.parse("2023-05-01T23:59:20.511Z"), "Mojisola", "Blog Title 2", "Sample Text 2 with target"),
                new Blog(3L, Instant.parse("2023-06-01T23:59:30.511Z"), "Salaudeen", "Blog Title 3", "Sample Text 3"),
                new Blog(4L, Instant.parse("2023-03-01T23:59:10.511Z"), "NotLatifah", "Blog Title 4", "Sample Text 4 target"), 
                new Blog(5L, Instant.parse("2023-02-01T23:59:20.511Z"), "NotMojisola", "Blog Title 5", "Sample Text 5 has target"),
                new Blog(6L, Instant.parse("2023-01-01T23:59:30.511Z"), "NotSalaudeen", "Blog Title 6", "Sample Text 6")
                ));
    @Test
    void testMergeBlog() {

    }

    @Test
    void testMergeSortBlog() {

    }

    @Test
    void testSearchBlogAuthor() {

    }

    @Test
    void testSearchBlogContent() {

    }
}
