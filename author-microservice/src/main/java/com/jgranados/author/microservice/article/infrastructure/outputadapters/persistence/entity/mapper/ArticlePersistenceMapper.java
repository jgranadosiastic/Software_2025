/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.author.microservice.article.infrastructure.outputadapters.persistence.entity.mapper;

import com.jgranados.author.microservice.article.domain.Article;
import com.jgranados.author.microservice.article.infrastructure.outputadapters.persistence.entity.ArticleDbEntity;
import com.jgranados.author.microservice.author.infrastructure.outputadapters.persistence.entity.mapper.AuthorPersistenceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author jose
 */
@Component
public class ArticlePersistenceMapper {

    private final AuthorPersistenceMapper authorPersistenceMapper;

    @Autowired
    public ArticlePersistenceMapper(AuthorPersistenceMapper authorPersistenceMapper) {
        this.authorPersistenceMapper = authorPersistenceMapper;
    }

    public Article toDomain(ArticleDbEntity dbEntity) {
        if (dbEntity == null) {
            return null;
        }

        return new Article(dbEntity.getId(),
                authorPersistenceMapper.toDomain(dbEntity.getAuthor()),
                dbEntity.getTitle(),
                dbEntity.getDescription(),
                dbEntity.getText(),
                dbEntity.getPublicationDate(),
                dbEntity.isActive(),
                dbEntity.isVisible()
        );
    }

    public ArticleDbEntity toDbEntity(Article article) {
        if (article == null) {
            return null;
        }

        return new ArticleDbEntity(article.getId(),
                authorPersistenceMapper.toDbEntity(article.getAuthor()),
                article.getTitle(),
                article.getDescription(),
                article.getText(),
                article.getPublicationDate(),
                article.isActive(),
                article.isVisible()
        );
    }
}
