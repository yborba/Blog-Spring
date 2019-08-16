package com.spring.blog.usecase;

import com.spring.blog.entities.Article;
import com.spring.blog.entities.Comment;
import com.spring.blog.gateway.BlogRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddComment {

    @Autowired
    private BlogRepository repositoryBlog;

    Article article;

    public Article existArticle (String id){
        Article article = repositoryBlog.findById(id).get();
        return article;
    }

    public boolean execute(Comment comment){
        try {
            Article article = existArticle(comment.getIdArticle());
            article.getComments().add(comment);
            repositoryBlog.save(article);
            return true;
        } catch (Exception e) {
            //TODO: handle exception
            return false;
        }
    }
}