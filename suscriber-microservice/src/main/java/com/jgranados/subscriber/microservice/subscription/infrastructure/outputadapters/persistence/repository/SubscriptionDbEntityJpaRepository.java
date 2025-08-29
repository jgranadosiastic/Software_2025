/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jgranados.subscriber.microservice.subscription.infrastructure.outputadapters.persistence.repository;

import com.jgranados.subscriber.microservice.subscription.infrastructure.outputadapters.persistence.entity.SubscriptionDbEntity;
import com.jgranados.subscriber.microservice.subscription.infrastructure.outputadapters.persistence.entity.SubscriptionDbPK;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jose
 */
public interface SubscriptionDbEntityJpaRepository extends JpaRepository<SubscriptionDbEntity, SubscriptionDbPK>{
    
}
