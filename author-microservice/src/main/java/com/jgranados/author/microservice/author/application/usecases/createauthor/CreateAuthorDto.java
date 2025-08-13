/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.author.microservice.author.application.usecases.createauthor;

import lombok.AllArgsConstructor;
import lombok.Value;

/**
 *
 * @author jose
 */
@Value
@AllArgsConstructor
public class CreateAuthorDto {
    
    private String email;
    private String name;
    private String profession;
    private String about;
}
