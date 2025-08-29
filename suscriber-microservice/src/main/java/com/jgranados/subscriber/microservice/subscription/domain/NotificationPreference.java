/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.subscriber.microservice.subscription.domain;

import lombok.Value;

/**
 *
 * @author jose
 */
@Value
public class NotificationPreference {

    private final boolean withNotifications;

    public NotificationPreference(boolean withNotifications) {
        this.withNotifications = withNotifications;
    }

    public boolean isWithNotifications() {
        return withNotifications;
    }

}
