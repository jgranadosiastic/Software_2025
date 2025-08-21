/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.author.microservice.common.application.exceptions;

/**
 *
 * @author jose
 */
public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String message) {
        super(message);
    }
    
    public EntityNotFoundException(Class clazz) {
        super(String.format("Entity of type {} not found", clazz.getCanonicalName()));
    }
    
    public EntityNotFoundException(Class clazz, String message) {
        super(String.format("Entity of type {} not found: {}", clazz.getCanonicalName(), message));
    }
}
