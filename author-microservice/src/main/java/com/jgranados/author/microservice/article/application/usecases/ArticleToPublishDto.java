/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.author.microservice.article.application.usecases;

import com.jgranados.author.microservice.article.domain.Article;
import com.jgranados.author.microservice.author.domain.Author;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.Value;

/**
 *
 * @author jose
 */
@Value
public class ArticleToPublishDto {
    @NotNull
    private final UUID authorId;
    @NotBlank
    private final String title;
    private final String description;
    @NotBlank
    private final String text;
    
    public Article toDomain(Author author) {
        return new Article(author, title, description, text);
    }
}
