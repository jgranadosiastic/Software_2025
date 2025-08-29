/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jgranados.subscriber.microservice.subscriber.application.outputport.persistence;

import com.jgranados.subscriber.microservice.subscriber.domain.Subscriber;
import com.jgranados.subscriber.microservice.subscriber.domain.SubscriberId;
import java.util.Optional;

/**
 *
 * @author jose
 */
public interface FindingSubscriberByIdOutputPort {
    Optional<Subscriber> findSubscriberById(SubscriberId subscriberId);
}
