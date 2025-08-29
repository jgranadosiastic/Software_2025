/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.subscriber.microservice.subscription.infrastructure.outputadapters.persistence.entity.mapper;

import com.jgranados.subscriber.microservice.subscriber.infrastructure.outputport.persistence.entity.mapper.SubscriberPersistenceMapper;
import com.jgranados.subscriber.microservice.subscription.domain.Subscription;
import com.jgranados.subscriber.microservice.subscription.infrastructure.outputadapters.persistence.entity.SubscriptionDbEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author jose
 */
@Component
public class SubscriptionPersistenceMapper {

    private final SubscriberPersistenceMapper subscriberPersistenceMapper;

    @Autowired
    public SubscriptionPersistenceMapper(SubscriberPersistenceMapper subscriberPersistenceMapper) {
        this.subscriberPersistenceMapper = subscriberPersistenceMapper;
    }

    public Subscription toDomain(SubscriptionDbEntity dbEntity) {
        return new Subscription(subscriberPersistenceMapper.toDomain(dbEntity.getSubscriber()),
                dbEntity.getAuthorId(),
                dbEntity.getSubscriptionDate(),
                dbEntity.getWithNotifications());
    }

    public SubscriptionDbEntity fromDomain(Subscription subscription) {
        return new SubscriptionDbEntity(subscriberPersistenceMapper.toDbEntity(subscription.getSubscriber()),
                subscription.getSubscriptionId().getAuthorId(),
                subscription.getSubscriptionDate().getDate(),
                subscription.getNotificationPreference().isWithNotifications());
    }
}
