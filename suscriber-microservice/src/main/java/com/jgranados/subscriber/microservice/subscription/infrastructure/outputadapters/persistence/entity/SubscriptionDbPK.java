/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.subscriber.microservice.subscription.infrastructure.outputadapters.persistence.entity;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author jose
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionDbPK {
    private UUID subscriberId;
    private UUID authorId;
}
