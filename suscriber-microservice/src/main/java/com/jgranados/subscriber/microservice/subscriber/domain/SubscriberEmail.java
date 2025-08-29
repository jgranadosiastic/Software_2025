/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.subscriber.microservice.subscriber.domain;

import java.util.regex.Pattern;
import lombok.Value;

/**
 *
 * @author jose
 */
@Value
public class SubscriberEmail {
    private final String email;
    
    public SubscriberEmail(String email) {
        if (email == null) {
            throw new IllegalArgumentException("Email should not be null.");
        }
        
        if (!Pattern.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", email)) {
            throw new IllegalArgumentException("Email should have a valid format.");
        }
        this.email = email;
    }
}
