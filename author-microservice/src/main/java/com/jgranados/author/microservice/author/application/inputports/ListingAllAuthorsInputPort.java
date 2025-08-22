/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.author.microservice.author.application.inputports;

import com.jgranados.author.microservice.author.domain.Author;
import java.util.List;

/**
 *
 * @author jose
 */
public interface ListingAllAuthorsInputPort {
    
    List<Author> listAllAuthors();
}
