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
        Article detailArticleResult = detailArticle.execute("4e1c2f01-cc7d-4291-b1d4-2eb4e52fb9e7");

        assertNotNull(detailArticleResult);
    }
}