package com.spring.blog.usecase;

import com.spring.blog.entities.Article;
import com.spring.blog.entities.valueobject.DateValidator;
import com.spring.blog.gateway.BlogRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateArticle {

    @Autowired
    private BlogRepository repositoryBlog;

    DateValidator dateValidator = new DateValidator();

    public boolean execute(Article article){
        try {
            if (dateValidator.dateValidator(article.getDate())){
                repositoryBlog.save(article);
                return true;
            }else{
                return false;
            }
            
        } catch (Exception e) {
            //TODO: handle exception
            return false;
        }
    }
}