package com.hu.lingoapp.game.domain.models;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public @Data class Game {
    private long id;
    private Player player;
    private Word answer;
    private int turn;

    private LocalDateTime timeStarted;
    private LocalDateTime timeEnded;
    private LocalDateTime timeLastGuess;

    private List<Letter> guessedLetters;

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

    public Game(long id, Player player, Word answer, LocalDateTime timeStarted) {
        this.id = id;
        this.player = player;
        this.answer = answer;
        this.timeStarted = timeStarted;
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

    public void combineLists(List<Letter> newGuessedLetters) {
        List<Letter> updated = new ArrayList<>();

        for (Letter newLetter: newGuessedLetters) {
            for (Letter oldLetter: guessedLetters){
                if (newLetter.isCorrect()) updated.add(newLetter);
                if (oldLetter == null) updated.add(newLetter);
            }
        }
        guessedLetters = updated;
    }
}
