package com.cbfacademy.apiassessment.blog;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class BlogStub implements ContentManager{
   
    static List<ContentManager> blogStub = new ArrayList<>(){
        { 
        add(new Blog(10L, Instant.parse("2022-04-01T23:59:10.511Z"), "NotLatifah", "Blog TitleStub 10", "Sample StubText 10")); 
        add(new Blog(20L, Instant.parse("2022-05-01T23:59:20.511Z"), "NotMojisola", "Blog TitleStub 20", "Sample StubText 20"));
        add(new Blog(30L, Instant.parse("2022-06-01T23:59:30.511Z"), "NotSalaudeen", "Blog TitleStub 30", "Sample StubText 30"));
        }
    }; 

    public static List<ContentManager> getBlogStub(){
        return blogStub;
    }

    @Override
    public Long getId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }

    @Override
    public void setId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setId'");
    }

    @Override
    public Instant getDate() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDate'");
    }

    @Override
    public void setDate(Instant date) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setDate'");
    }

    @Override
    public String getAuthor() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAuthor'");
    }

    @Override
    public void setAuthor(String author) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setAuthor'");
    }

    @Override
    public String getTitle() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTitle'");
    }

    @Override
    public void setTitle(String title) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setTitle'");
    }

    @Override
    public String getContent() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getContent'");
    }

    @Override
    public void setContent(String content) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setContent'");
    }

}
