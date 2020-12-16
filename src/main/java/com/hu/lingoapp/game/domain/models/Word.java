package com.hu.lingoapp.game.domain.models;

import lombok.Data;

public @Data class Word {
    private long id;
    private String text;
    private String bundle;

    public Word() {}

    public Word(String text) {
        this.text = text;
    }

    public Word(String text, String bundle) {
        this.text = text;
        this.bundle = bundle;
    }
}
