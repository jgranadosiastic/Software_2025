/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.author.microservice.article.application.outputports.persistence;

import com.jgranados.author.microservice.article.domain.Article;

/**
 *
 * @author jose
 */
public interface StoringArticleOutputPort {
    Article save(Article article);
}
