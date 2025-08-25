/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jgranados.author.microservice.article.application.inputports;

import com.jgranados.author.microservice.article.application.usecases.ArticleToPublishDto;
import com.jgranados.author.microservice.common.application.exceptions.EntityNotFoundException;

/**
 *
 * @author jose
 */
public interface PublishingArticleInputPort {
    
    void publishArticle(ArticleToPublishDto articleToPublish) throws EntityNotFoundException;
}
