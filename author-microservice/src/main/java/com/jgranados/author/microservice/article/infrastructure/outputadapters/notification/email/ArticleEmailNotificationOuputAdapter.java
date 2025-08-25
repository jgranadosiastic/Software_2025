/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.author.microservice.article.infrastructure.outputadapters.notification.email;

import com.jgranados.author.microservice.article.application.outputports.notifications.NewArticleNotificationPort;
import com.jgranados.author.microservice.article.domain.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 *
 * @author jose
 */
@Component
@Slf4j
public class ArticleEmailNotificationOuputAdapter implements NewArticleNotificationPort {

    @Override
    public void notifyNewArticlePublished(Article article) {
        log.info("La notificacion puede ser a cada suscriptor usando eventos o comunicacion con otro microservicio");
    }
    
}
