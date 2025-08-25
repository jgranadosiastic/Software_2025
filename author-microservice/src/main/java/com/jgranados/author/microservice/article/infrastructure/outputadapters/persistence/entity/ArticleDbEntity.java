/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.author.microservice.article.infrastructure.outputadapters.persistence.entity;

import com.jgranados.author.microservice.author.infrastructure.outputadapters.persistence.entity.AuthorDbEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "article")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDbEntity {

    @Id
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private AuthorDbEntity author;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private String text;
    @Column
    private LocalDate publicationDate;
    @Column
    private boolean active;
    @Column
    private boolean visible;
}
