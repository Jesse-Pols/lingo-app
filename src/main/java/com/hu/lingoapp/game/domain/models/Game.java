package com.hu.lingoapp.game.domain.models;

import lombok.Data;

public @Data class Game {
    private Long id;
    private int player_id;

    public Game() {}

    public Game(Long id) {
        this.id = id;
    }

    public Game(Long id, int player_id) {
        this.id = id;
        this.player_id = player_id;
    }
}
