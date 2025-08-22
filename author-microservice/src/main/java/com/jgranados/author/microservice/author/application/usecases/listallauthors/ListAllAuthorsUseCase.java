/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.author.microservice.author.application.usecases.listallauthors;

import com.jgranados.author.microservice.author.application.factory.AuthorFactory;
import com.jgranados.author.microservice.author.application.inputports.ListingAllAuthorsInputPort;
import com.jgranados.author.microservice.author.application.outputports.persistence.FindingAllAuthorsOutputPort;
import com.jgranados.author.microservice.author.domain.Author;
import com.jgranados.author.microservice.common.application.annotations.UseCase;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author jose
 */
@UseCase
public class ListAllAuthorsUseCase implements ListingAllAuthorsInputPort {

    private final FindingAllAuthorsOutputPort findingAllAuthorsPort;
    private final AuthorFactory authorFactory;

    @Autowired
    public ListAllAuthorsUseCase(FindingAllAuthorsOutputPort findingAllAuthorsPort,
            AuthorFactory authorFactory) {
        this.findingAllAuthorsPort = findingAllAuthorsPort;
        this.authorFactory = authorFactory;
    }

    @Override
    public List<Author> listAllAuthors() {
        return findingAllAuthorsPort.findAllAuthors()
                .stream()
                .map(author -> authorFactory.createAuthorWithArticleCount(author))
                .toList();
    }

}
