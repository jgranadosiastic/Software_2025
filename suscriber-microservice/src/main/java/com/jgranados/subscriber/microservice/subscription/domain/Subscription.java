/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.subscriber.microservice.subscription.domain;

import com.jgranados.subscriber.microservice.common.domain.annotations.DomainEntity;
import com.jgranados.subscriber.microservice.subscriber.domain.Subscriber;
import com.jgranados.subscriber.microservice.subscriber.domain.SubscriberId;
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
    private SubscriptionId subscriptionId;
    private SubscriptionDate subscriptionDate;
    private NotificationPreference notificationPreference;

    public Subscription(Subscriber subscriber, UUID authorId, NotificationPreference notificationPreference) {
        this.subscriber = subscriber;
        this.subscriptionId = new SubscriptionId(subscriber.getId(), authorId);
        this.subscriptionDate = new SubscriptionDate(LocalDate.now());
        this.notificationPreference = notificationPreference;
    }
    
    public Subscription(Subscriber subscriber, UUID authorId, LocalDate subscriptionDate, boolean withNotification) {
        this.subscriber = subscriber;
        this.subscriptionId = new SubscriptionId(subscriber.getId(), authorId);
        this.subscriptionDate = new SubscriptionDate(LocalDate.now());
        this.notificationPreference = new NotificationPreference(withNotification);
    }
    
}
