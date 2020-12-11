package com.hu.lingoapp.game.domain.models;

import lombok.Data;

import java.time.LocalTime;

public @Data class Game {
    private long id;
    private Player player;
    private Word answer;

    private LocalTime timeStarted;
    private LocalTime timeEnded;
    private LocalTime timeLastGuess;

    public Game() {}

    public Game(long id) {
        this.id = id;
    }

    public Game(long id, Player player) {
        this.id = id;
        this.player = player;
    }

    public Game(long id, Player player, Word answer) {
        this.id = id;
        this.player = player;
        this.answer = answer;
    }
}
