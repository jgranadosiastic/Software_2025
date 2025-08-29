/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jgranados.subscriber.microservice.subscription.application.outputports.rest;

import java.util.UUID;

/**
 *
 * @author jose
 */
public interface ExistsAuthorOutputPort {
    
    boolean existsAuthor(UUID authorId);
}
