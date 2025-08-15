/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.author.microservice.author.infrastructure.outputadapters.persistence.entity.mapper;

import com.jgranados.author.microservice.author.domain.Author;
import com.jgranados.author.microservice.author.infrastructure.outputadapters.persistence.entity.AuthorDbEntity;
import org.springframework.stereotype.Component;

/**
 *
 * @author jose
 */
@Component
public class AuthorPersistenceMapper {

    public Author toDomain(AuthorDbEntity dbEntity) {
        if (dbEntity == null) {
            return null;
        }

        return new Author(dbEntity.getId(),
                dbEntity.getName(),
                dbEntity.getEmail(),
                dbEntity.getProfession(),
                dbEntity.getAbout()
        );
    }

    public AuthorDbEntity toDbEntity(Author author) {
        if (author == null) {
            return null;
        }

        return new AuthorDbEntity(author.getId(),
                author.getEmail(),
                author.getName(),
                author.getProfession(),
                author.getAbout()
        );
    }
}
