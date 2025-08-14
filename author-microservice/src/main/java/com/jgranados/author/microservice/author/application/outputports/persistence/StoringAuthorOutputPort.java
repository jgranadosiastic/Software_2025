/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jgranados.author.microservice.author.application.outputports.persistence;

import com.jgranados.author.microservice.author.domain.Author;

/**
 *
 * @author jose
 */
public interface StoringAuthorOutputPort {
    Author save(Author author);
}
