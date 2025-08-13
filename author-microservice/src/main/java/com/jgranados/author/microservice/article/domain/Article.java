/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.author.microservice.article.domain;

import com.jgranados.author.microservice.author.domain.Author;
import java.time.LocalDate;
import java.util.UUID;
import lombok.Getter;

/**
 *
 * @author jose
 */
@Getter
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
        this.textVO = new TextArticle(text);
        this.active = true;
        this.visible = true;
    }
    
    
    
    public boolean isValidContent() {
        if (text == null) {
            return false;
        }
        
        return text.length() >= 200;
    }
}
