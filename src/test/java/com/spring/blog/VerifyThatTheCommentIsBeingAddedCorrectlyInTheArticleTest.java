package com.spring.blog;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.spring.blog.entities.Comment;
import com.spring.blog.usecase.AddComment;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VerifyThatTheCommentIsBeingAddedCorrectlyInTheArticleTest {
    
    @Autowired
    AddComment addComment;

    Comment comment = new Comment("Test", "Comment to check the comment of an article", "4e1c2f01-cc7d-4291-b1d4-2eb4e52fb9e7");

    Comment invalidComment = new Comment("Test", "Comment to check the comment of an article", "4e1c2f01-cc7d-4291-b1d4-2eb4e52fb9e8"); //ID nonexistent
    
    @Test
    public void testAddComment(){
        boolean result = addComment.execute(comment);

        assertTrue(result);
    }
    
    @Test
    public void testAddInvalidComment(){
        boolean result = addComment.execute(invalidComment);

        assertFalse(result);
    }
}