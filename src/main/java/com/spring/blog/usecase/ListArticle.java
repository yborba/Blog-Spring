package com.spring.blog.usecase;

import java.util.List;
import java.util.stream.Collectors;

import com.spring.blog.entities.Article;
import com.spring.blog.entities.dto.ResumeArticleDTO;
import com.spring.blog.gateway.BlogRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListArticle {

    @Autowired
    private BlogRepository repositoryBlog;
    @Autowired
    private ModelMapper modelMapper;

    public Iterable<ResumeArticleDTO> execute(){
        List<Article> posts = (List<Article>) repositoryBlog.findAll();
        return posts.stream().map(post -> convertToDto(post)).collect(Collectors.toList());
        }
    
        private ResumeArticleDTO convertToDto(Article post) {
            ResumeArticleDTO postDto = modelMapper.map(post, ResumeArticleDTO.class); 
            if(post.getText().length() >= 150){
            postDto.setText(postDto.getText().substring(0, 150) + "...");
            }
            postDto.setAmountComments(post.getComments().size());
            return postDto;
        }
    
}