/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.author.microservice.author.application.usecases.createauthor;

import com.jgranados.author.microservice.author.application.inputports.CreatingAuthorInputPort;
import com.jgranados.author.microservice.author.application.outputports.persistence.FindingAuthorByEmailOutputPort;
import com.jgranados.author.microservice.common.application.exceptions.EntityAlreadyExistsException;
import com.jgranados.author.microservice.author.application.outputports.notifications.NewAuthorRegistrationNotificationPort;
import com.jgranados.author.microservice.author.application.outputports.persistence.StoringAuthorOutputPort;
import com.jgranados.author.microservice.author.domain.Author;
import com.jgranados.author.microservice.common.application.annotations.UseCase;
import jakarta.validation.Valid;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

/**
 *
 * @author jose
 */
@UseCase
@Validated
public class CreateAuthorUseCase implements CreatingAuthorInputPort {
    
    private final FindingAuthorByEmailOutputPort findingByEmailPort;
    private final StoringAuthorOutputPort storingAuthorPort;
    private final NewAuthorRegistrationNotificationPort newAuthorNotificationPort;

    public CreateAuthorUseCase(FindingAuthorByEmailOutputPort findingByEmailPort,
            NewAuthorRegistrationNotificationPort newAuthorNotificationPort,
            StoringAuthorOutputPort storingAuthorPort) {
        this.findingByEmailPort = findingByEmailPort;
        this.newAuthorNotificationPort = newAuthorNotificationPort;
        this.storingAuthorPort = storingAuthorPort;
    }
    
    

    @Override
    @Transactional
    public Author createAuthor(@Valid CreateAuthorDto authorDto) throws EntityAlreadyExistsException {
        // Validar que el email no exista
        if (findingByEmailPort.findByEmail(authorDto.getEmail()).isPresent()) {
            throw new EntityAlreadyExistsException("Author with email already registered");
        }
        
        // Crear nuevo autor
        Author newAuthor = authorDto.toDomain();
        
        // Persistir
        Author savedAuthor = storingAuthorPort.save(newAuthor);
        
        // Notificar
        newAuthorNotificationPort.notifyNewAuthorRegistration(savedAuthor);
        
        return savedAuthor;
    }
    
}
