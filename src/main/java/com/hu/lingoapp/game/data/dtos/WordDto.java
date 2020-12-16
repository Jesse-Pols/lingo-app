package com.hu.lingoapp.game.data.dtos;

import lombok.Data;

import javax.persistence.*;

@Entity
@NamedQuery(name = "WordDto.countValidWords", query = "SELECT COUNT(*) FROM WordDto WHERE length(text) BETWEEN 5 AND 7")
@NamedQuery(name = "WordDto.getValidWords", query = "SELECT w FROM WordDto w WHERE length(text) BETWEEN 5 AND 7")
@Table(name = "words")
public @Data
class WordDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String text;
    private String bundle;

    public WordDto() {}
}
