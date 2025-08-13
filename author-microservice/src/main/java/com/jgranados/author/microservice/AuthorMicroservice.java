/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.author.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author jose
 */
@SpringBootApplication
@EnableTransactionManagement
public class AuthorMicroservice {

    public static void main(String[] args) {
		SpringApplication.run(AuthorMicroservice.class, args);
	}
}
