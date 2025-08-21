/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.author.microservice.author.infrastructure.inputadapters.rest.dto;

import com.jgranados.author.microservice.author.domain.Author;
import java.util.UUID;
import lombok.Value;

/**
 *
 * @author jose
 */
@Value
public class AuthorResponse {

    private final UUID id;
    private final String name;
    private final String email;
    private final String profession;
    private final String about;
    private final int numberOfArticles;

    public static AuthorResponse fromDomain(Author author) {
        return new AuthorResponse(author.getId(),
                author.getName(),
                author.getEmail(),
                author.getProfession(),
                author.getAbout(),
                author.getNumberOfArticles());
    }
}
