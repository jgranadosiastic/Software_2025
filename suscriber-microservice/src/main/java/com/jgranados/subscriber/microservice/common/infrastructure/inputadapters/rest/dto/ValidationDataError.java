/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.subscriber.microservice.common.infrastructure.inputadapters.rest.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Value;

/**
 *
 * @author jose
 */
@Value
@AllArgsConstructor
public class ValidationDataError {
    private final List<String> messages;
}
