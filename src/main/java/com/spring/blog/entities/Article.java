package com.spring.blog.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Article {

    private String id;
    private String title;
    private String date;
    private String author;
    private String text;
    private List<String> tag;
    private ArrayList<Comment> comments;    

    public Article(String title, String date, String author, String text, List<String> tag){
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.date = date;
        this.author = author;
        this.text = text;
        this.tag = tag;
        this.comments = new ArrayList<Comment>();
    }
}