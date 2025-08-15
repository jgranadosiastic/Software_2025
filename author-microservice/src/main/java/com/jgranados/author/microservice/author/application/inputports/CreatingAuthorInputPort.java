/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jgranados.author.microservice.author.application.inputports;

import com.jgranados.author.microservice.author.application.usecases.createauthor.CreateAuthorDto;
import com.jgranados.author.microservice.author.domain.Author;
import com.jgranados.author.microservice.common.application.exceptions.EntityAlreadyExistsException;
import jakarta.validation.Valid;

/**
 *
 * @author jose
 */
public interface CreatingAuthorInputPort {
    
    Author createAuthor(@Valid CreateAuthorDto authorDto) throws EntityAlreadyExistsException;
}
