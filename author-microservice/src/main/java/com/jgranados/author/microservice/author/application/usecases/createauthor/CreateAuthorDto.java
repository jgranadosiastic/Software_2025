/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.author.microservice.author.application.usecases.createauthor;

import com.jgranados.author.microservice.author.domain.Author;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Value;

/**
 *
 * @author jose
 */
@Value
@AllArgsConstructor
public class CreateAuthorDto {
    
    @Email
    private String email;
    @NotBlank
    private String name;
    private String profession;
    private String about;
    
    public Author toDomain() {
        return new Author(name, email, profession, about);
    }
}
