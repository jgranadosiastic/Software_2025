/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.subscriber.microservice.subscription.infrastructure.inputadapters.rest.dto;

import com.jgranados.subscriber.microservice.subscription.application.usercases.subscribetoauthor.SubscribeToAuthorDto;
import java.util.UUID;
import lombok.Value;

/**
 *
 * @author jose
 */
@Value
public class SubscriptionRequest {
    private final UUID authorId;
    private final boolean withNotifications;
    
    public SubscribeToAuthorDto toDomain(UUID subscriberId) {
        return new SubscribeToAuthorDto(subscriberId, authorId, withNotifications);
    }
}
