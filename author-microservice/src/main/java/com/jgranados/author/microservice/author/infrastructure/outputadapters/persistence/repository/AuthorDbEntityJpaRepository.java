/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jgranados.author.microservice.author.infrastructure.outputadapters.persistence.repository;

import com.jgranados.author.microservice.author.infrastructure.outputadapters.persistence.entity.AuthorDbEntity;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jose
 */
@Repository
public interface AuthorDbEntityJpaRepository extends JpaRepository<AuthorDbEntity, UUID> {

    Optional<AuthorDbEntity> findByEmail(String email);
}
