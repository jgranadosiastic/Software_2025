/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.subscriber.microservice.subscription.domain;

import com.jgranados.subscriber.microservice.subscriber.domain.SubscriberId;
import java.util.UUID;
import lombok.Value;

/**
 *
 * @author jose
 */
@Value
public class SubscriptionId {
    private final SubscriberId subscriberId;
    private final UUID authorId;
    
    public SubscriptionId(SubscriberId subscriberId, UUID authorId) {
        if (subscriberId == null || authorId == null) {
            throw new IllegalArgumentException("Both subscriber Id and author Id are needed.");
        }
        
        if (subscriberId.getId().equals(authorId)) {
            throw new IllegalArgumentException("Cannot subscribe to yourself");
        }
        
        this.subscriberId = subscriberId;
        this.authorId = authorId;
    }
    
}
