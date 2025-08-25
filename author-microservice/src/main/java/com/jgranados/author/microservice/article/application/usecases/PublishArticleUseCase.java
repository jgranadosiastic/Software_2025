/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.author.microservice.article.application.usecases;

import com.jgranados.author.microservice.article.application.inputports.PublishingArticleInputPort;
import com.jgranados.author.microservice.article.application.outputports.notifications.NewArticleNotificationPort;
import com.jgranados.author.microservice.article.application.outputports.persistence.StoringArticleOutputPort;
import com.jgranados.author.microservice.article.domain.Article;
import com.jgranados.author.microservice.author.application.outputports.persistence.FindingAuthorByIdOutputPort;
import com.jgranados.author.microservice.author.domain.Author;
import com.jgranados.author.microservice.common.application.annotations.UseCase;
import com.jgranados.author.microservice.common.application.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author jose
 */
@UseCase
public class PublishArticleUseCase implements PublishingArticleInputPort {

    private final FindingAuthorByIdOutputPort findingAuthorByIdPort;
    private final StoringArticleOutputPort storingArticlePort;
    private final NewArticleNotificationPort newArticleNotificationPort;

    @Autowired
    public PublishArticleUseCase(FindingAuthorByIdOutputPort findingAuthorByIdPort,
            StoringArticleOutputPort storingArticlePort,
            NewArticleNotificationPort newArticleNotificationPort) {
        this.findingAuthorByIdPort = findingAuthorByIdPort;
        this.storingArticlePort = storingArticlePort;
        this.newArticleNotificationPort = newArticleNotificationPort;
    }

    @Override
    public void publishArticle(ArticleToPublishDto articleToPublish) throws EntityNotFoundException {
        
        Author autor = findingAuthorByIdPort.findById(articleToPublish.getAuthorId())
                .orElseThrow(() -> new EntityNotFoundException(Author.class));
        
        Article newArticle = articleToPublish.toDomain(autor);
        
        Article savedArticle = storingArticlePort.save(newArticle);
        
        newArticleNotificationPort.notifyNewArticlePublished(savedArticle);
        
    }

}
