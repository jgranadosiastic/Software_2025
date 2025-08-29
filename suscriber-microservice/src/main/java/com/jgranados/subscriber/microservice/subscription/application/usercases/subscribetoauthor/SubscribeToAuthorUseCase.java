/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.subscriber.microservice.subscription.application.usercases.subscribetoauthor;

import com.jgranados.subscriber.microservice.common.application.annotations.UseCase;
import com.jgranados.subscriber.microservice.common.application.exceptions.EntityAlreadyExistsException;
import com.jgranados.subscriber.microservice.common.application.exceptions.EntityNotFoundException;
import com.jgranados.subscriber.microservice.subscription.application.inputports.SubscribingToAuthorInputPort;
import com.jgranados.subscriber.microservice.subscriber.application.outputport.persistence.FindingSubscriberByIdOutputPort;
import com.jgranados.subscriber.microservice.subscriber.domain.Subscriber;
import com.jgranados.subscriber.microservice.subscription.application.outputports.rest.ExistsAuthorOutputPort;
import com.jgranados.subscriber.microservice.subscription.application.outputports.persistence.FindingSubscriptionByIdOutputPort;
import com.jgranados.subscriber.microservice.subscription.application.outputports.persistence.StoringSubscriptionOutputPort;
import com.jgranados.subscriber.microservice.subscription.domain.Subscription;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author jose
 */
@UseCase
public class SubscribeToAuthorUseCase implements  SubscribingToAuthorInputPort {

    private final FindingSubscriberByIdOutputPort findingSubscriberOutputPort;
    private final ExistsAuthorOutputPort existsAuthorOutputPort;
    private final FindingSubscriptionByIdOutputPort findingSubscriptionByIdOutputPort;
    private final StoringSubscriptionOutputPort storingSubscriptionOutputPort;

    @Autowired
    public SubscribeToAuthorUseCase(FindingSubscriberByIdOutputPort findingSubscriberOutputPort,
            ExistsAuthorOutputPort existsAuthorOutputPort,
            FindingSubscriptionByIdOutputPort findingSubscriptionByIdOutputPort,
            StoringSubscriptionOutputPort storingSubscriptionOutputPort) {
        this.findingSubscriberOutputPort = findingSubscriberOutputPort;
        this.existsAuthorOutputPort = existsAuthorOutputPort;
        this.findingSubscriptionByIdOutputPort = findingSubscriptionByIdOutputPort;
        this.storingSubscriptionOutputPort = storingSubscriptionOutputPort;
    }
    
    
    
    
    @Override
    public void subscribeToAuthor(SubscribeToAuthorDto subscribeToAuthorDto) throws EntityNotFoundException, EntityAlreadyExistsException {
        // verify the author exists
        if (existsAuthorOutputPort.existsAuthor(subscribeToAuthorDto.getAuthorId())) {
            throw new EntityNotFoundException("Author does not exists.");
        }
        
        // verify exists subscriber
        Subscriber subscriber = findingSubscriberOutputPort
                .findSubscriberById(subscribeToAuthorDto.getSubscriberId())
                .orElseThrow(() -> new EntityNotFoundException(Subscriber.class));
        
        // verify subscription does not exists
        if (findingSubscriptionByIdOutputPort.findSubscriptionById(subscriber.getId(), subscribeToAuthorDto.getAuthorId()).isPresent()) {
            throw new EntityAlreadyExistsException("Subscription already exists.");
        } 
        
        Subscription subscription = subscribeToAuthorDto.toDomain(subscriber);
        
        // saving
        storingSubscriptionOutputPort.save(subscription);
    }
    
}
