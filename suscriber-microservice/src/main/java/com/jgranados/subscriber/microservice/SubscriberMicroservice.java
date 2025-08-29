/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.subscriber.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestClient;

/**
 *
 * @author jose
 */
@SpringBootApplication
@EnableTransactionManagement
public class SubscriberMicroservice {

    public static void main(String[] args) {
        SpringApplication.run(SubscriberMicroservice.class, args);
    }

    @Bean("AuthorRestApi")
    public RestClient restClient() {
        return RestClient.builder()
                .baseUrl("http://localhost:8080/api/v1/authors/")
                .build();
    }
}
