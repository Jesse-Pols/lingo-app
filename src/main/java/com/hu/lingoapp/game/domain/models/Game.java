package com.hu.lingoapp.game.domain.models;

import lombok.Data;

import java.time.LocalDateTime;

public @Data class Game {
    private long id;
    private Player player;
    private Word answer;
    private int turn;

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

    public Game(LocalDateTime timeStarted, LocalDateTime timeLastGuess) {
        this.timeLastGuess = timeLastGuess;
        this.timeStarted = timeStarted;
    }

    // If no guess has been done yet, return the time at which the game was created
    public LocalDateTime getLatestGuess() {
        if (this.timeLastGuess == null) return this.timeStarted;
        return this.timeLastGuess;
    }

    public String getAnswerString() {
        Word word = this.answer;
        if (word == null) return null;
        return word.getText();
    }
}
