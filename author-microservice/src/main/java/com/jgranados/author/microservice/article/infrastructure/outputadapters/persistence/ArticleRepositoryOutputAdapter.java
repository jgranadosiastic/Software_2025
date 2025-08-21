/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.author.microservice.article.infrastructure.outputadapters.persistence;

import com.jgranados.author.microservice.article.application.outputports.persistence.CountingArticlesByAuthorOutputPort;
import com.jgranados.author.microservice.article.infrastructure.outputadapters.persistence.repository.ArticleDbEntityJpaRepository;
import com.jgranados.author.microservice.common.infrastructure.annotations.PersistenceAdapter;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jose
 */
@PersistenceAdapter
public class ArticleRepositoryOutputAdapter implements CountingArticlesByAuthorOutputPort {
    
    private final ArticleDbEntityJpaRepository articleJpaRepository;

    @Autowired
    public ArticleRepositoryOutputAdapter(ArticleDbEntityJpaRepository articleJpaRepository) {
        this.articleJpaRepository = articleJpaRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public int countArticlesByAuthorId(UUID authorId) {
        return articleJpaRepository.countByAuthorId(authorId);
    }
    
}
