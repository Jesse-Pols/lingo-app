package com.hu.lingoapp.game.domain.models;

import lombok.Data;

import java.util.List;

public @Data class Player {
    private long id;
    private String name;
    private int score;

    public Player() {}

    public Player(long id, String name, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }
}
