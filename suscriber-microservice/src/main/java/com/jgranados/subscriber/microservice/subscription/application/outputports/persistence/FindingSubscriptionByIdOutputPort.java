/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jgranados.subscriber.microservice.subscription.application.outputports.persistence;

import com.jgranados.subscriber.microservice.subscriber.domain.SubscriberId;
import com.jgranados.subscriber.microservice.subscription.domain.Subscription;
import java.util.Optional;
import java.util.UUID;

/**
 *
 * @author jose
 */
public interface FindingSubscriptionByIdOutputPort {
    Optional<Subscription> findSubscriptionById(SubscriberId subscriberId, UUID authorID);
}
