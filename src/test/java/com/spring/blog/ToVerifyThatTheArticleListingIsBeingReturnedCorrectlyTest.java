package com.spring.blog;

import static org.junit.Assert.assertNotNull;

import com.spring.blog.entities.Article;
import com.spring.blog.usecase.DetailArticle;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ToVerifyThatTheArticleListingIsBeingReturnedCorrectlyTest {

    @Autowired
    DetailArticle detailArticle;

    @Test
    public void listAllArticle(){
        Article detailArticleResult = detailArticle.execute("4a78a863-e3ae-4318-a456-492e50a3363a");

        assertNotNull(detailArticleResult);
    }
}