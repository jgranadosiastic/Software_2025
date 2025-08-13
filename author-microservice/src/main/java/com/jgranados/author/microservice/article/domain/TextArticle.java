/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.author.microservice.article.domain;

/**
 *
 * @author jose
 */
public class TextArticle {

    private final String text;

    public TextArticle(String text) {
        this.text = text;
        validateText();
    }
    
    

    private void validateText() {

        if (text == null|| text.length() < 200) {
            throw new IllegalArgumentException("Texto no valido");
        }

    }
}
