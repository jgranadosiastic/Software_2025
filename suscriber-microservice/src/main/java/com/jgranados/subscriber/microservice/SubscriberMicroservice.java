/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.subscriber.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

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
}
