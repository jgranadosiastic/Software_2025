/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.subscriber.microservice.subscription.infrastructure.outputadapters.persistence;

import com.jgranados.subscriber.microservice.common.infrastructure.annotations.PersistenceAdapter;
import com.jgranados.subscriber.microservice.subscription.application.outputports.persistence.FindingSubscriptionByIdOutputPort;
import com.jgranados.subscriber.microservice.subscription.application.outputports.persistence.StoringSubscriptionOutputPort;
import com.jgranados.subscriber.microservice.subscription.domain.Subscription;
import com.jgranados.subscriber.microservice.subscription.domain.SubscriptionId;
import com.jgranados.subscriber.microservice.subscription.infrastructure.outputadapters.persistence.entity.SubscriptionDbEntity;
import com.jgranados.subscriber.microservice.subscription.infrastructure.outputadapters.persistence.entity.SubscriptionDbPK;
import com.jgranados.subscriber.microservice.subscription.infrastructure.outputadapters.persistence.entity.mapper.SubscriptionIdPersistenceAdapter;
import com.jgranados.subscriber.microservice.subscription.infrastructure.outputadapters.persistence.entity.mapper.SubscriptionPersistenceMapper;
import com.jgranados.subscriber.microservice.subscription.infrastructure.outputadapters.persistence.repository.SubscriptionDbEntityJpaRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jose
 */
@PersistenceAdapter
public class SubscriptionRepositoryOutputAdapter implements FindingSubscriptionByIdOutputPort, StoringSubscriptionOutputPort {
    
    private final SubscriptionDbEntityJpaRepository jpaRepository;
    private final SubscriptionPersistenceMapper subscriptionPersistenceMapper;
    private final SubscriptionIdPersistenceAdapter subscriptionIdPersistenceMapper;

    @Autowired
    public SubscriptionRepositoryOutputAdapter(SubscriptionDbEntityJpaRepository jpaRepository,
            SubscriptionPersistenceMapper subscriptionPersistenceMapper,
            SubscriptionIdPersistenceAdapter subscriptionIdPersistenceMapper) {
        this.jpaRepository = jpaRepository;
        this.subscriptionPersistenceMapper = subscriptionPersistenceMapper;
        this.subscriptionIdPersistenceMapper = subscriptionIdPersistenceMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Subscription> findSubscriptionById(SubscriptionId subscriptionId) {
        SubscriptionDbPK primaryKey = subscriptionIdPersistenceMapper.fromDomain(subscriptionId);
        
        return jpaRepository.findById(primaryKey)
                .map(subscriptionPersistenceMapper::toDomain);
    }

    @Override
    public Subscription save(Subscription subscription) {
        SubscriptionDbEntity entity = subscriptionPersistenceMapper.fromDomain(subscription);
        
        entity = jpaRepository.save(entity);
        
        return subscriptionPersistenceMapper.toDomain(entity);
    }
    
}
