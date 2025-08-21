/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.author.microservice.author.domain;

import com.jgranados.author.microservice.common.domain.annotations.DomainEntity;
import java.util.UUID;
import lombok.Getter;

/**
 *
 * @author jose
 */
@Getter
@DomainEntity
public class Author {
    
    private UUID id;
    private String email;
    private String name;
    private String profession;
    private String about;
    private int numberOfArticles;
    
    public Author(UUID id, String name, String email, String profession, String about) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.about = about;
        this.profession = profession;
        this.numberOfArticles = 0;
    }
    
    public Author(UUID id, String name, String email, String profession, String about, int articleCount) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.about = about;
        this.profession = profession;
        this.numberOfArticles = articleCount;
    }
    
    public Author(String name, String email, String profession, String about) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.email = email;
        this.about = about;
        this.profession = profession;
        this.numberOfArticles = 0;
    }
    
    // Comportamiento de dominio
    public void incrementArticleCount() {
        this.numberOfArticles++;
    }
}
