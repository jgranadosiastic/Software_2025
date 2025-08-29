/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.subscriber.microservice.subscription.domain;

import com.jgranados.subscriber.microservice.common.domain.annotations.DomainEntity;
import com.jgranados.subscriber.microservice.subscriber.domain.Subscriber;
import java.time.LocalDate;
import java.util.UUID;
import lombok.Getter;

/**
 *
 * @author jose
 */
@Getter
@DomainEntity
public class Subscription {
    private Subscriber subscriber;
    
    private SubscriptionDate subscriptionDate;
    private NotificationPreference notificationPreference;

    public Subscription(Subscriber subscriber, UUID authorId, NotificationPreference notificationPreference) {
        this.subscriber = subscriber;
        this.subscriptionDate = new SubscriptionDate(LocalDate.now());
        this.notificationPreference = notificationPreference;
    }
    
    
}
