package com.cbfacademy.apiassessment.blog;

import java.time.Instant;


public interface ContentManager {
    
    public Long getId();

    public void setId(Long id);
    
    public Instant getDate();

    public void setDate(Instant date);

    public String getAuthor();

    public void setAuthor(String author);

    public String getTitle();

    public void setTitle(String title); 

    public String getContent();

    public void setContent(String content);
}
