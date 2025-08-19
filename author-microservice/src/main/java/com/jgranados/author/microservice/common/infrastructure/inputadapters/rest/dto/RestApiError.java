/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.author.microservice.common.infrastructure.inputadapters.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Value;

/**
 *
 * @author jose
 */
@Value
@AllArgsConstructor
public class RestApiError {
    private final int statusCode;
    private final String message;
}
