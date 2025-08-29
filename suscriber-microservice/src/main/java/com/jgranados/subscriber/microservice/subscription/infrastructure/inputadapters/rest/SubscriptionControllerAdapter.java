/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.subscriber.microservice.subscription.infrastructure.inputadapters.rest;

import com.jgranados.subscriber.microservice.common.infrastructure.annotations.WebAdapter;
import com.jgranados.subscriber.microservice.subscription.application.inputports.SubscribingToAuthorInputPort;
import com.jgranados.subscriber.microservice.subscription.application.usercases.subscribetoauthor.SubscribeToAuthorDto;
import com.jgranados.subscriber.microservice.subscription.infrastructure.inputadapters.rest.dto.SubscriptionRequest;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jose
 */
@RestController
@RequestMapping("/api/v1/subscribers/{subscriberId}/subscriptions")
@WebAdapter
public class SubscriptionControllerAdapter {

    private final SubscribingToAuthorInputPort subscribingToAuthorInputPort;

    @Autowired
    public SubscriptionControllerAdapter(SubscribingToAuthorInputPort subscribingToAuthorInputPort) {
        this.subscribingToAuthorInputPort = subscribingToAuthorInputPort;
    }

    @PostMapping
    public ResponseEntity<Void> subscribeToAuthor(@PathVariable("subscriberId") UUID subscriberId,
            @RequestBody SubscriptionRequest subscriptionRequest) {

        SubscribeToAuthorDto subscribeToAuthorDto = subscriptionRequest.toDomain(subscriberId);

        subscribingToAuthorInputPort.subscribeToAuthor(subscribeToAuthorDto);

        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

}
