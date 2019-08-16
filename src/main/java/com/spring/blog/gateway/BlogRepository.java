package com.spring.blog.gateway;

import com.microsoft.azure.spring.data.cosmosdb.repository.DocumentDbRepository;
import com.spring.blog.entities.Article;

import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends DocumentDbRepository<Article, String> {
    
}