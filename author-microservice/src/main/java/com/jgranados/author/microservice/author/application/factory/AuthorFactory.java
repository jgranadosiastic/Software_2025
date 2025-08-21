/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.author.microservice.author.application.factory;

import com.jgranados.author.microservice.article.application.outputports.persistence.CountingArticlesByAuthorOutputPort;
import com.jgranados.author.microservice.author.domain.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author jose
 */
@Component
public class AuthorFactory {

    private final CountingArticlesByAuthorOutputPort articleCountPort;

    @Autowired
    public AuthorFactory(CountingArticlesByAuthorOutputPort articleCountPort) {
        this.articleCountPort = articleCountPort;
    }

    public Author createAuthorWithArticleCount(Author author) {
        int count = articleCountPort.countArticlesByAuthorId(author.getId());
        return new Author(author.getId(),
                author.getName(),
                author.getEmail(),
                author.getProfession(),
                author.getAbout(),
                count);
    }

}
