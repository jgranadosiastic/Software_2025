/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.author.microservice.author.infrastructure.inputadapters.rest;

import com.jgranados.author.microservice.author.application.inputports.CreatingAuthorInputPort;
import com.jgranados.author.microservice.author.application.usecases.createauthor.CreateAuthorDto;
import com.jgranados.author.microservice.author.domain.Author;
import com.jgranados.author.microservice.author.infrastructure.inputadapters.rest.dto.CreateAuthorRequest;
import com.jgranados.author.microservice.author.infrastructure.inputadapters.rest.dto.CreatedAuthorResponse;
import com.jgranados.author.microservice.common.infrastructure.annotations.WebAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jose
 */
@RestController
@RequestMapping("/api/v1/aauthors")
@WebAdapter
public class AuthorControllerAdapter {
    
    
    
    private final CreatingAuthorInputPort creatingAuthorInputPort;

    @Autowired
    public AuthorControllerAdapter(CreatingAuthorInputPort creatingAuthorInputPort) {
        this.creatingAuthorInputPort = creatingAuthorInputPort;
    }
    
    
    @PostMapping
    public ResponseEntity<CreatedAuthorResponse> createAuthor(@RequestBody CreateAuthorRequest createAuthorRequest) {
        CreateAuthorDto objectAdaptedFromREstoToDomain = createAuthorRequest.toDomain();
        
        Author author = creatingAuthorInputPort.createAuthor(objectAdaptedFromREstoToDomain);
        
        CreatedAuthorResponse response = CreatedAuthorResponse.fromDomain(author);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }    
    
}
