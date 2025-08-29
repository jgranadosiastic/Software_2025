/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jgranados.subscriber.microservice.subscription.application.inputports;

import com.jgranados.subscriber.microservice.common.application.exceptions.EntityAlreadyExistsException;
import com.jgranados.subscriber.microservice.common.application.exceptions.EntityNotFoundException;
import com.jgranados.subscriber.microservice.subscription.application.usercases.subscribetoauthor.SubscribeToAuthorDto;

/**
 *
 * @author jose
 */
public interface SubscribingToAuthorInputPort {
    void subscribeToAuthor(SubscribeToAuthorDto subscribeToAuthorDto) throws EntityNotFoundException, EntityAlreadyExistsException;
}
