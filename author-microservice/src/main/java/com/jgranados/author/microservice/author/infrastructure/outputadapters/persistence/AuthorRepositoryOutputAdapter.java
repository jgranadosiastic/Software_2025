/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.author.microservice.author.infrastructure.outputadapters.persistence;

import com.jgranados.author.microservice.author.application.outputports.persistence.FindingAllAuthorsOutputPort;
import com.jgranados.author.microservice.author.application.outputports.persistence.StoringAuthorOutputPort;
import com.jgranados.author.microservice.author.domain.Author;
import com.jgranados.author.microservice.author.infrastructure.outputadapters.persistence.entity.AuthorDbEntity;
import com.jgranados.author.microservice.author.infrastructure.outputadapters.persistence.entity.mapper.AuthorPersistenceMapper;
import com.jgranados.author.microservice.author.infrastructure.outputadapters.persistence.repository.AuthorDbEntityJpaRepository;
import com.jgranados.author.microservice.common.infrastructure.annotations.PersistenceAdapter;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.jgranados.author.microservice.author.application.outputports.persistence.FindingAuthorByEmailOutputPort;
import com.jgranados.author.microservice.author.application.outputports.persistence.FindingAuthorByIdOutputPort;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author jose
 */
@PersistenceAdapter
public class AuthorRepositoryOutputAdapter implements FindingAuthorByEmailOutputPort,
        StoringAuthorOutputPort, FindingAuthorByIdOutputPort, FindingAllAuthorsOutputPort {

    private final AuthorDbEntityJpaRepository authorJpaRepository;
    private final AuthorPersistenceMapper authorPersistenceMapper;

    @Autowired
    public AuthorRepositoryOutputAdapter(AuthorDbEntityJpaRepository authorJpaRepository,
            AuthorPersistenceMapper authorPersistenceMapper) {
        this.authorJpaRepository = authorJpaRepository;
        this.authorPersistenceMapper = authorPersistenceMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Author> findByEmail(String email) {
        return authorJpaRepository.findByEmail(email)
                .map(dbEntity -> authorPersistenceMapper.toDomain(dbEntity));
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Author save(Author author) {
        AuthorDbEntity savedEntity = authorJpaRepository.save(authorPersistenceMapper.toDbEntity(author));

        return authorPersistenceMapper.toDomain(savedEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Author> findById(UUID id) {
        return authorJpaRepository.findById(id)
                .map(dbEntity -> authorPersistenceMapper.toDomain(dbEntity));
    }

    @Override
    public List<Author> findAllAuthors() {
        return authorJpaRepository.findAll()
                .stream()
                .map(dbEntity -> authorPersistenceMapper.toDomain(dbEntity))
                .toList();
    }

}
