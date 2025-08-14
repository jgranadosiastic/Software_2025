/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.author.microservice.author.infrastructure.inputadapters.rest.dto;

import com.jgranados.author.microservice.author.domain.Author;
import java.util.UUID;
import lombok.AllArgsConstructor;

/**
 *
 * @author jose
 */
@AllArgsConstructor
public class CreatedAuthorResponse {
    
    private UUID id;
    private String name;
    private String email;
    
    
    public static CreatedAuthorResponse fromDomain(Author author) {
        return new CreatedAuthorResponse(author.getId(), author.getName(), author.getEmail());
    }
    
}
