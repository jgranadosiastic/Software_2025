/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.subscriber.microservice.subscription.infrastructure.outputadapters.persistence.entity.mapper;

import com.jgranados.subscriber.microservice.subscriber.domain.SubscriberId;
import com.jgranados.subscriber.microservice.subscription.domain.SubscriptionId;
import com.jgranados.subscriber.microservice.subscription.infrastructure.outputadapters.persistence.entity.SubscriptionDbPK;
import org.springframework.stereotype.Component;

/**
 *
 * @author jose
 */
@Component
public class SubscriptionIdPersistenceAdapter {

    public SubscriptionId toDomain(SubscriptionDbPK subscriptionDbPK) {
        return new SubscriptionId(SubscriberId.fromUUID(subscriptionDbPK.getSubscriberId()),
                subscriptionDbPK.getAuthorId());
    }

    public SubscriptionDbPK fromDomain(SubscriptionId subscriptionId) {
        return new SubscriptionDbPK(subscriptionId.getSubscriberId().getId(),
                subscriptionId.getAuthorId());
    }
}
