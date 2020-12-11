package com.hu.lingoapp.game.domain.models;

import lombok.Data;

import java.time.LocalDateTime;

public @Data class Game {
    private long id;
    private Player player;
    private Word answer;

    private LocalDateTime timeStarted;
    private LocalDateTime timeEnded;
    private LocalDateTime timeLastGuess;

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
