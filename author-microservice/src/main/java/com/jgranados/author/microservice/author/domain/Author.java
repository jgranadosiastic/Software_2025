/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.author.microservice.author.domain;

import java.util.UUID;
import lombok.Getter;

/**
 *
 * @author jose
 */
@Getter
public class Author {
    
    private UUID id;
    private String email;
    private String name;
    private String profession;
    private String about;
    private int numberOfArticles;
    
    public Author(String name, String email) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.email = email;
        this.numberOfArticles = 0;
    }
    
    // Comportamiento de dominio
    public void incrementArticleCount() {
        this.numberOfArticles++;
    }
}
