package com.hu.lingoapp.game.domain.models;

import lombok.Data;

public @Data
class Letter {
    private int index;
    private String letter;
    private boolean correct;
    private boolean present;

    public Letter(int index, String letter, boolean correct, boolean present) {
        this.letter = letter;
        this.index = index;
        this.correct = correct;
        this.present = present;
    }
}
