/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.subscriber.microservice.subscriber.infrastructure.outputport.persistence.entity.mapper;

import com.jgranados.subscriber.microservice.subscriber.domain.Subscriber;
import com.jgranados.subscriber.microservice.subscriber.infrastructure.outputport.persistence.entity.SubscriberDbEntity;
import org.springframework.stereotype.Component;

/**
 *
 * @author jose
 */
@Component
public class SubscriberPersistenceMapper {

    public Subscriber toDomain(SubscriberDbEntity dbEntity) {
        if (dbEntity == null) {
            return null;
        }
        return new Subscriber(dbEntity.getId(),
                dbEntity.getEmail(),
                dbEntity.getName());
    }

    public SubscriberDbEntity toDbEntity(Subscriber subscriber) {
        if (subscriber == null) {
            return null;
        }
        return new SubscriberDbEntity(subscriber.getId().getId(),
                subscriber.getEmail().getEmail(),
                subscriber.getName().getName());
    }
}
