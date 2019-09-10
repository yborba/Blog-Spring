package com.spring.blog.gateway;

import com.spring.blog.entities.Article;
import com.spring.blog.entities.Comment;
import com.spring.blog.entities.dto.ResumeArticleDTO;
import com.spring.blog.usecase.AddComment;
import com.spring.blog.usecase.CreateArticle;
import com.spring.blog.usecase.DetailArticle;
import com.spring.blog.usecase.EditArticle;
import com.spring.blog.usecase.ListArticle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController {

    @Autowired
    private CreateArticle createArticle;
    @Autowired
    private DetailArticle detailArticle;
    @Autowired
    private ListArticle listArticle;
    @Autowired
    private AddComment addComment;
    @Autowired
    private EditArticle editArticle;


    @RequestMapping(method = RequestMethod.POST, value = "/create")
        public void createArticle(@RequestBody Article article){
            createArticle.execute(article);
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/list")
        public Iterable<ResumeArticleDTO> listArticle(){
            return listArticle.execute();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/detail")
        public Article detailArticle (@RequestParam (value = "id") String id){
            return detailArticle.execute(id);
    }
    
    @RequestMapping(method = RequestMethod.PUT, value = "/edit")
        public void editArticle (@RequestBody Article article){
            editArticle.execute(article);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/comment")
        public void addComment (@RequestBody Comment comment){
            addComment.execute(comment);
    }
}