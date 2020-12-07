package com.hu.lingoapp.game.data.dtos;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "words")
public @Data
class WordDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;
    private String language;

    public WordDto() {}
}
