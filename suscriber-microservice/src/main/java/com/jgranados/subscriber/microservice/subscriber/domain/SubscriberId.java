/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.subscriber.microservice.subscriber.domain;

import java.util.UUID;
import lombok.Value;

/**
 *
 * @author jose
 */
@Value
public class SubscriberId {

    private final UUID id;

    private SubscriberId(UUID id) {
        this.id = id;
    }

    public static SubscriberId generate() {
        return new SubscriberId(UUID.randomUUID());
    }
    
    public static SubscriberId fromUUID(UUID id) {
        return new SubscriberId(id);
    }
}
