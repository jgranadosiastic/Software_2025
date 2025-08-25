/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.author.microservice.article.infrastructure.inputadapters.rest;

import com.jgranados.author.microservice.article.application.inputports.PublishingArticleInputPort;
import com.jgranados.author.microservice.article.application.usecases.ArticleToPublishDto;
import com.jgranados.author.microservice.article.infrastructure.inputadapters.rest.dto.PublishArticleRequest;
import com.jgranados.author.microservice.common.infrastructure.annotations.WebAdapter;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jose
 */
@RestController
@RequestMapping("/api/v1/authors/{id}/articles")
@WebAdapter
public class ArticleControllerAdapter {
    
    private final PublishingArticleInputPort publishingArticleInputPort;

    @Autowired
    public ArticleControllerAdapter(PublishingArticleInputPort publishingArticleInputPort) {
        this.publishingArticleInputPort = publishingArticleInputPort;
    }
    
    @PostMapping
    public ResponseEntity<Void> publishingArticle(@RequestBody PublishArticleRequest articleRequest,
            @PathVariable(name = "id") UUID authorId) {
        ArticleToPublishDto articleToPublish = articleRequest.toDomain(authorId);
        
        publishingArticleInputPort.publishArticle(articleToPublish);
        
        return ResponseEntity.status(HttpStatus.CREATED).build();
    } 
}
