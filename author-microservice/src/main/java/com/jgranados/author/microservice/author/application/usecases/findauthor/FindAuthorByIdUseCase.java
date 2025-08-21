/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.author.microservice.author.application.usecases.findauthor;

import com.jgranados.author.microservice.author.application.factory.AuthorFactory;
import com.jgranados.author.microservice.author.domain.Author;
import com.jgranados.author.microservice.common.application.exceptions.EntityNotFoundException;
import com.jgranados.author.microservice.author.application.inputports.FindingAuthorByIdInputPort;
import com.jgranados.author.microservice.author.application.outputports.persistence.FindingAuthorByIdOutputPort;
import com.jgranados.author.microservice.common.application.annotations.UseCase;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author jose
 */
@UseCase
public class FindAuthorByIdUseCase implements FindingAuthorByIdInputPort {

    private final FindingAuthorByIdOutputPort findingByIdPort;
    private final AuthorFactory authorFactory;

    @Autowired
    public FindAuthorByIdUseCase(FindingAuthorByIdOutputPort findingByIdPort,
            AuthorFactory authorFactory) {
        this.findingByIdPort = findingByIdPort;
        this.authorFactory = authorFactory;
    }
    
    @Override
    public Author findById(UUID authorId) throws EntityNotFoundException {
        // finding author by id or throw exception
        Author author = findingByIdPort.findById(authorId)
                .orElseThrow(() -> new EntityNotFoundException(Author.class));
        
        // get the number of articles
        Author authorWithCount = authorFactory.createAuthorWithArticleCount(author);
        
        // return
        return authorWithCount;
        
    }
    
}
