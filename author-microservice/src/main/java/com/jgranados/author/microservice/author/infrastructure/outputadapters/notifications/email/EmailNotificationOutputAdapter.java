/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.author.microservice.author.infrastructure.outputadapters.notifications.email;

import com.jgranados.author.microservice.author.application.outputports.notifications.NewAuthorRegistrationNotificationPort;
import com.jgranados.author.microservice.author.domain.Author;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 *
 * @author jose
 */
@Component
@Slf4j
public class EmailNotificationOutputAdapter implements NewAuthorRegistrationNotificationPort {

    @Override
    public void notifyNewAuthorRegistration(Author author) {
        log.info("Enviando email de bienvenida a: {}", author.getEmail());
    }
    
}
