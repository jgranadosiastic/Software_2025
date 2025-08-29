/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.subscriber.microservice.subscription.application.usercases.subscribetoauthor;

import com.jgranados.subscriber.microservice.subscriber.domain.Subscriber;
import com.jgranados.subscriber.microservice.subscriber.domain.SubscriberId;
import com.jgranados.subscriber.microservice.subscription.domain.NotificationPreference;
import com.jgranados.subscriber.microservice.subscription.domain.Subscription;
import java.util.UUID;
import lombok.Value;

/**
 *
 * @author jose
 */
@Value
public class SubscribeToAuthorDto {
    private final SubscriberId subscriberId;
    private final UUID authorId;
    private final NotificationPreference notificationPreference;
    
    public SubscribeToAuthorDto(UUID subscriberId, UUID authorId, boolean withNotification) {
        this.subscriberId = SubscriberId.fromUUID(subscriberId);
        this.authorId = authorId;
        this.notificationPreference = new NotificationPreference(withNotification);
    }
    
    public Subscription toDomain(Subscriber subscriber) {
        return new Subscription(subscriber, authorId, notificationPreference);
    }
}
