package com.hu.lingoapp.game.domain.domainobjects;

import lombok.Data;

import java.util.List;

public @Data class Player {
    private Long id;
    private String name;
    private int score;

    private List<Game> games;

    public Player() {}

    public Player(Long id, String name, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public Player(Long id, String name, int score, List<Game> games) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.games = games;
    }
}
