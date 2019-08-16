package com.spring.blog.gateway;

import com.microsoft.azure.spring.data.cosmosdb.repository.DocumentDbRepository;
import com.spring.blog.entities.Comment;

import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends DocumentDbRepository<Comment, String> {

    Iterable<Comment> findAllCommentsByIdArticle(String idArticle);
}