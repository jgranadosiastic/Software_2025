/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.subscriber.microservice.subscriber.infrastructure.outputport.persistence;

import com.jgranados.subscriber.microservice.common.infrastructure.annotations.PersistenceAdapter;
import com.jgranados.subscriber.microservice.subscriber.application.outputport.persistence.FindingSubscriberByIdOutputPort;
import com.jgranados.subscriber.microservice.subscriber.domain.Subscriber;
import com.jgranados.subscriber.microservice.subscriber.domain.SubscriberId;
import com.jgranados.subscriber.microservice.subscriber.infrastructure.outputport.persistence.entity.mapper.SubscriberPersistenceMapper;
import com.jgranados.subscriber.microservice.subscriber.infrastructure.outputport.persistence.repository.SubscriberDbEntityJpaRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jose
 */
@PersistenceAdapter
public class SubscriberRepositoryOutputAdapter implements FindingSubscriberByIdOutputPort {

    private final SubscriberDbEntityJpaRepository jpaRepository;
    private final SubscriberPersistenceMapper persistenceAdapter;

    @Autowired
    public SubscriberRepositoryOutputAdapter(SubscriberDbEntityJpaRepository jpaRepository,
            SubscriberPersistenceMapper persistenceAdapter) {
        this.jpaRepository = jpaRepository;
        this.persistenceAdapter = persistenceAdapter;
    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<Subscriber> findSubscriberById(SubscriberId subscriberId) {
        return jpaRepository.findById(subscriberId.getId())
                .map(persistenceAdapter::toDomain);
    }
    
}
