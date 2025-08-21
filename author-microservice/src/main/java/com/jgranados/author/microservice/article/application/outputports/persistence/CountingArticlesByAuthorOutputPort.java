/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.author.microservice.article.application.outputports.persistence;

import java.util.UUID;

/**
 *
 * @author jose
 */
public interface CountingArticlesByAuthorOutputPort {
    int countArticlesByAuthorId(UUID authorId);
}
