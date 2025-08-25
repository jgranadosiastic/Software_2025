/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jgranados.author.microservice.article.application.outputports.notifications;

import com.jgranados.author.microservice.article.domain.Article;

/**
 *
 * @author jose
 */
public interface NewArticleNotificationPort {
    void notifyNewArticlePublished(Article article);
}
