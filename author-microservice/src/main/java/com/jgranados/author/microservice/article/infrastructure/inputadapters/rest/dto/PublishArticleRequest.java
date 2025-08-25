/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.author.microservice.article.infrastructure.inputadapters.rest.dto;

import com.jgranados.author.microservice.article.application.usecases.ArticleToPublishDto;
import java.util.UUID;
import lombok.Value;

/**
 *
 * @author jose
 */
@Value
public class PublishArticleRequest {

    private final String title;
    private final String description;
    private final String text;

    public ArticleToPublishDto toDomain(UUID authorId) {
        return new ArticleToPublishDto(authorId, title, description, text);
    }
}
