package com.hu.lingoapp.game.data.dtos;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "players")
public @Data
class PlayerDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private int score;

    public PlayerDto() {}

    public PlayerDto(long id, String name, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public PlayerDto(long id) {
        this.id = id;
    }
}