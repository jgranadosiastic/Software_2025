/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jgranados.author.microservice.author.application.outputports.notifications;

import com.jgranados.author.microservice.author.domain.Author;

/**
 *
 * @author jose
 */
public interface NewAuthorRegistrationNotificationPort {
    void notifyNewAuthorRegistration(Author author);
}
