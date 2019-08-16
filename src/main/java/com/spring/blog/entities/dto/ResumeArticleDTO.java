package com.spring.blog.entities.dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResumeArticleDTO {

    private String id;
    private String title;
    private String date;
    private String author;
    private String text;
    private List<String> tag;
    private int amountComments;
   
}