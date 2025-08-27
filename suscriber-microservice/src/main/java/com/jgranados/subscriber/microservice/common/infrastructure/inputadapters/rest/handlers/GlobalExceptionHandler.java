/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.subscriber.microservice.common.infrastructure.inputadapters.rest.handlers;

import com.jgranados.subscriber.microservice.common.application.exceptions.EntityAlreadyExistsException;
import com.jgranados.subscriber.microservice.common.application.exceptions.EntityNotFoundException;
import com.jgranados.subscriber.microservice.common.infrastructure.inputadapters.rest.dto.RestApiError;
import com.jgranados.subscriber.microservice.common.infrastructure.inputadapters.rest.dto.ValidationDataError;
import jakarta.validation.ConstraintViolationException;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 *
 * @author jose
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(EntityAlreadyExistsException.class)
    public ResponseEntity<RestApiError> handleEntityAlreadyExists(EntityAlreadyExistsException ex) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(new RestApiError(HttpStatus.CONFLICT.value(), ex.getMessage()));
    }
    
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ValidationDataError> handleVAlidationConstraintException(ConstraintViolationException ex) {
        List<String> errors = ex.getConstraintViolations().stream()
                .map(error -> error.getMessage())
                .toList();
        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ValidationDataError(errors));
    }
    
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ValidationDataError> handleIllegalArgumentException(IllegalArgumentException ex) {
        List<String> errors = Collections.singletonList(ex.getMessage());
        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ValidationDataError(errors));
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<RestApiError> handleAuthorNotFound(EntityNotFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new RestApiError(HttpStatus.NOT_FOUND.value(), ex.getMessage()));
    }
}
