/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.author.microservice.author.infrastructure.inputadapters.rest.dto;

import com.jgranados.author.microservice.author.domain.Author;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Value;

/**
 *
 * @author jose
 */
@AllArgsConstructor
@Value
public class CreatedAuthorResponse {
    
    private final UUID id;
    private final String name;
    private final String email;
    
    
    public static CreatedAuthorResponse fromDomain(Author author) {
        return new CreatedAuthorResponse(author.getId(), author.getName(), author.getEmail());
    }
    
}
