/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.subscriber.microservice.subscriber.domain;

import com.jgranados.subscriber.microservice.common.domain.annotations.DomainEntity;
import java.util.UUID;
import lombok.Getter;

/**
 *
 * @author jose
 */
@Getter
@DomainEntity
public class Subscriber {
    public SubscriberId id;
    public SubscriberEmail email;
    public SubscriberName name;

    public Subscriber(String email, String name) {
        this.id = SubscriberId.generate();
        this.email = new SubscriberEmail(email);
        this.name = new SubscriberName(name);
    }
    
    public Subscriber(UUID subscriberId, String email, String name) {
        this.id = SubscriberId.fromUUID(subscriberId);
        this.email = new SubscriberEmail(email);
        this.name = new SubscriberName(name);
    }
    
}
