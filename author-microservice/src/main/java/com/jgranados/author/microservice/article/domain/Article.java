/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.author.microservice.article.domain;

import com.jgranados.author.microservice.author.domain.Author;
import com.jgranados.author.microservice.common.domain.annotations.DomainEntity;
import java.time.LocalDate;
import java.util.UUID;
import lombok.Getter;

/**
 *
 * @author jose
 */
@Getter
@DomainEntity
public class Article {

    private UUID id;
    private Author author;
    private String title;
    private String description;
    private String text;
    private TextArticle textVO;
    private LocalDate publicationDate;

    private boolean active;
    private boolean visible;

    public Article(Author author, String title, String description, String text) {
        this.id = UUID.randomUUID();
        this.author = author;
        this.title = title;
        this.description = description;
        this.textVO = new TextArticle(text); // value objects are better than just rely on bean validations
        this.active = true;
        this.visible = true;
        publicationDate = LocalDate.now();
    }

    public Article(UUID id, Author author, String title, String description, String text, LocalDate publicationDate, boolean active, boolean visible) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.description = description;
        this.text = text;
        this.publicationDate = publicationDate;
        this.active = active;
        this.visible = visible;
    }

    public boolean isValidContent() {
        if (text == null) {
            return false;
        }

        return text.length() >= 200;
    }
}
