package com.spring.blog.entities;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Comment {

    private String id;
    private String author;
    private String comment;
    private String idArticle;

    public Comment (String author, String comment, String idArticle){
        this.id = UUID.randomUUID().toString();
        this.author = author;
        this.comment = comment;
        this.idArticle = idArticle;
    }    
}