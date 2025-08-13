/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.author.microservice.author.application.usecases.createauthor;

import com.jgranados.author.microservice.author.domain.Author;
import com.jgranados.author.microservice.author.application.inputports.CreatingAuthorInputPort;
import com.jgranados.author.microservice.common.application.exceptions.EntityAlreadyExistsException;

/**
 *
 * @author jose
 */
public class CreateAuthorUseCase implements CreatingAuthorInputPort {

    @Override
    public Author createAuthor(CreateAuthorDto authorDto) throws EntityAlreadyExistsException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
