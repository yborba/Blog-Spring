package com.spring.blog.usecase;

import com.spring.blog.entities.Article;
import com.spring.blog.gateway.BlogRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DetailArticle {

    @Autowired
    private BlogRepository repositoryBlog;

    public Article execute(String id){
            return repositoryBlog.findById(id).get();
    }
    
}