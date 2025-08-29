/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jgranados.subscriber.microservice.subscriber.infrastructure.outputport.persistence.repository;

import com.jgranados.subscriber.microservice.subscriber.infrastructure.outputport.persistence.entity.SubscriberDbEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jose
 */
public interface SubscriberDbEntityJpaRepository extends JpaRepository<SubscriberDbEntity, UUID>{
    
}
