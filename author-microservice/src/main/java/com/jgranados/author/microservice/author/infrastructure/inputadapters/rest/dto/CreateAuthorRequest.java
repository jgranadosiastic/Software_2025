/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.author.microservice.author.infrastructure.inputadapters.rest.dto;

import com.jgranados.author.microservice.author.application.usecases.createauthor.CreateAuthorDto;
import lombok.Value;

/**
 *
 * @author jose
 */
@Value
public class CreateAuthorRequest {
    private final String email;
    private final String name;
    private final String profession;
    private final String about;
    
    public CreateAuthorDto toDomain() {
        return new CreateAuthorDto(email, name, profession, about);
    }
}
