/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jgranados.author.microservice.author.application.outputports;

import com.jgranados.author.microservice.author.domain.Author;
import java.util.Optional;

/**
 *
 * @author jose
 */
public interface FindingAuthorByEmailOutputPort {
    Optional<Author> findByEMail(String email);
}
