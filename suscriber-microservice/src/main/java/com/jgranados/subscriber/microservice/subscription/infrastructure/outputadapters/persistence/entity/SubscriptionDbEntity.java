/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.subscriber.microservice.subscription.infrastructure.outputadapters.persistence.entity;

import com.jgranados.subscriber.microservice.subscriber.infrastructure.outputport.persistence.entity.SubscriberDbEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "subscription")
@Getter
@Setter
@NoArgsConstructor
@IdClass(SubscriptionDbPK.class)
public class SubscriptionDbEntity {
    @Id
    @Column(name = "subscriber_id")
    private UUID subscriberId;
    @Id
    private UUID authorId;
    
    @ManyToOne
    @JoinColumn(name = "subscriber_id", insertable = false, updatable = false)
    private SubscriberDbEntity subscriber;
    
    @Column
    private LocalDate subscriptionDate;
    @Column
    private Boolean withNotifications;

    public SubscriptionDbEntity(SubscriberDbEntity subscriber, UUID authorId, LocalDate subscriptionDate, Boolean withNotifications) {
        this.subscriberId = subscriber.getId();
        this.subscriber = subscriber;
        this.authorId = authorId;
        this.subscriptionDate = subscriptionDate;
        this.withNotifications = withNotifications;
    }
    
    
}
