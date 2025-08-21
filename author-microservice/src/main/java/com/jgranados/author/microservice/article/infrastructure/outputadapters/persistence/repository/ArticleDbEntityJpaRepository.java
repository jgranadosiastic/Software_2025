/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.author.microservice.article.infrastructure.outputadapters.persistence.repository;

import com.jgranados.author.microservice.article.infrastructure.outputadapters.persistence.entity.ArticleDbEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jose
 */
@Repository
public interface ArticleDbEntityJpaRepository extends JpaRepository<ArticleDbEntity, UUID> {
    
    int countByAuthorId(UUID authorId);
}
