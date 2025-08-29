/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.subscriber.microservice.subscription.domain;

import java.time.LocalDate;
import lombok.Value;

/**
 *
 * @author jose
 */
@Value
public class SubscriptionDate {
    private LocalDate date;
    
    public SubscriptionDate(LocalDate date) {
        if (date == null) {
            throw new IllegalArgumentException("Subscription date cannot be null");
        }
        if (date.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Subscription date cannot be in the future");
        }
        this.date = date;
    }
}
