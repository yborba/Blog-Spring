package com.spring.blog.usecase;

import com.spring.blog.entities.Article;
import com.spring.blog.gateway.BlogRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditArticle {
    
    @Autowired
    private BlogRepository repositoryBlog;

    public boolean execute(Article article){
        try {
            if (repositoryBlog.existsById(article.getId()) == true){
                repositoryBlog.save(article);
                return true;
            }return false;
        } catch (Exception e) {
            //TODO: handle exception
            return false;
        }
    }
    
}