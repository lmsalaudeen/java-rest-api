package com.cbfacademy.apiassessment.blog;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.InstantSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.google.gson.annotations.Expose;


public class Blog implements ContentManager {

    // @JsonProperty("id")
    private Long id;

    // @JsonProperty("date")
    // @JsonSerialize(using = InstantSerializer.class)
    // @JsonDeserialize(using = InstantDeserializer.class)
    private Instant date;
    
    private String author;
    
    private String title;

    private String content;

    public Blog(Long id, Instant date, String author, String title, String content) {
        this.id = id;
        this.date = date;
        this.author = author;
        this.title = title;
        this.content = content;
    }

    public Blog() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Instant getDate() {
        return date;
    }
    public void setDate(Instant date) {
        this.date = date;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    // @Override
    // public String toString() {
    //     return "{" +
    //             "id='" + id + '\'' +
    //             ", date='" + date + '\'' +
    //             ", author='" + author + '\'' +
    //             ", title='" + title + '\'' +
    //             ", content='" + content +
    //             '}';
    // }
}
