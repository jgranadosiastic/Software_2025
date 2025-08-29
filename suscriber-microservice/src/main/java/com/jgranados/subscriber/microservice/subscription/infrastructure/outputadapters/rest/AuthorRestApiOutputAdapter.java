/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.subscriber.microservice.subscription.infrastructure.outputadapters.rest;

import com.jgranados.subscriber.microservice.subscription.application.outputports.rest.ExistsAuthorOutputPort;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientResponseException;

/**
 *
 * @author jose
 */
// @RestApiAdapter we can crete this annotation
@Component
public class AuthorRestApiOutputAdapter implements ExistsAuthorOutputPort {
    
    private final RestClient authorRestClient;

    public AuthorRestApiOutputAdapter(@Qualifier("AuthorRestApi") RestClient authorRestClient) {
        this.authorRestClient = authorRestClient;
    }

    @Override
    public boolean existsAuthor(UUID authorId) {
        try {
            authorRestClient.head()
                .uri(authorId.toString())
                .retrieve()
                .toBodilessEntity();
            
            return true;
        } catch (RestClientResponseException e) {
            if (e.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
                return false;
            } else {
                // propagate with throws
                e.printStackTrace();
            }
        }
        
        return false;
    }
    
}
