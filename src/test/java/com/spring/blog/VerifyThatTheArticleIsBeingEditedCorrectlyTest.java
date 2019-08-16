package com.spring.blog;

import static org.junit.Assert.assertTrue;

import com.spring.blog.entities.Article;
import com.spring.blog.usecase.CreateArticle;
import com.spring.blog.usecase.EditArticle;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VerifyThatTheArticleIsBeingEditedCorrectlyTest {

    @Autowired
    EditArticle editArticle;
    @Autowired
    CreateArticle createArticle;

    Article article = new Article("title", "01/01/2001", "author", "text", null);
    
    @Test
    public void verifyEditArticle(){
        createArticle.execute(article);
        article.setTitle("Edited");

        Article articleEdited = article;

        boolean result = editArticle.execute(articleEdited);

        assertTrue(result);
    }
    
}