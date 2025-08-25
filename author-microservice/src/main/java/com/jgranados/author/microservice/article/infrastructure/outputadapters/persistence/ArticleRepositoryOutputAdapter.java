/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.author.microservice.article.infrastructure.outputadapters.persistence;

import com.jgranados.author.microservice.article.application.outputports.persistence.CountingArticlesByAuthorOutputPort;
import com.jgranados.author.microservice.article.application.outputports.persistence.StoringArticleOutputPort;
import com.jgranados.author.microservice.article.domain.Article;
import com.jgranados.author.microservice.article.infrastructure.outputadapters.persistence.entity.ArticleDbEntity;
import com.jgranados.author.microservice.article.infrastructure.outputadapters.persistence.entity.mapper.ArticlePersistenceMapper;
import com.jgranados.author.microservice.article.infrastructure.outputadapters.persistence.repository.ArticleDbEntityJpaRepository;
import com.jgranados.author.microservice.common.infrastructure.annotations.PersistenceAdapter;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jose
 */
@PersistenceAdapter
public class ArticleRepositoryOutputAdapter implements CountingArticlesByAuthorOutputPort,
        StoringArticleOutputPort {
    
    private final ArticleDbEntityJpaRepository articleJpaRepository;
    private final ArticlePersistenceMapper articlePercistenceMapper;

    @Autowired
    public ArticleRepositoryOutputAdapter(ArticleDbEntityJpaRepository articleJpaRepository,
            ArticlePersistenceMapper articlePercistenceMapper) {
        this.articleJpaRepository = articleJpaRepository;
        this.articlePercistenceMapper = articlePercistenceMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public int countArticlesByAuthorId(UUID authorId) {
        return articleJpaRepository.countByAuthorId(authorId);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Article save(Article article) {
        ArticleDbEntity savedEntity = articleJpaRepository.save(articlePercistenceMapper.toDbEntity(article));
        
        return articlePercistenceMapper.toDomain(savedEntity);
    }
    
}
