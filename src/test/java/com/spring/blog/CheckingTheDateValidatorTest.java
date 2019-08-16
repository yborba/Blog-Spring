package com.spring.blog;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.spring.blog.entities.Article;
import com.spring.blog.usecase.CreateArticle;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CheckingTheDateValidatorTest {

    @Autowired
    CreateArticle createArticle;
    
    @Test
    public void testYearYY(){
        Article articleYY = new Article("title", "01/01/21", "author", "text", null);
        
        boolean exit = createArticle.execute(articleYY);

        assertTrue(exit);
    }
    
    @Test
    public void testYearYYYY(){
        Article articleYYYY = new Article("title", "01/01/2001", "author", "text", null);
        
        boolean exit = createArticle.execute(articleYYYY);

        assertTrue(exit);
    }

    @Test
    public void testYearYYYYYY(){
        Article articleYYYYYY = new Article("title", "01/01/200001", "author", "text", null);

        boolean exit = createArticle.execute(articleYYYYYY);

        assertFalse(exit);
    }

    @Test
    public void testYearYYYYY(){
        Article articleYYYYY = new Article("title", "01/01/20001", "author", "text", null);

        boolean exit = createArticle.execute(articleYYYYY);

        assertFalse(exit);
    }

    @Test
    public void testYearYYY(){
        Article articleYYY = new Article("title", "01/01/201", "author", "text", null);

        boolean exit = createArticle.execute(articleYYY);

        assertFalse(exit);
    }

    @Test
    public void testYearY(){
        Article articleY = new Article("title", "01/01/2", "author", "text", null);

        boolean exit = createArticle.execute(articleY);

        assertFalse(exit);
    }
}