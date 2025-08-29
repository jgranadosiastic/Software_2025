/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.subscriber.microservice.subscriber.domain;

import lombok.Value;

/**
 *
 * @author jose
 */
@Value
public class SubscriberName {
    private final String name;
    
    public SubscriberName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name should not be null.");
        }
        
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name should not be blank.");
        }
        
        this.name = name;
    }
}
