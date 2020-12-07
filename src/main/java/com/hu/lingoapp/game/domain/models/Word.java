package com.hu.lingoapp.game.domain.models;

import lombok.Data;

public @Data class Word {
    private Long id;
    private String text;
    private String language;

    public Word() {}
}
