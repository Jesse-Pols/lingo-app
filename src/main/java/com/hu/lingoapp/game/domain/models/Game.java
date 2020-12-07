package com.hu.lingoapp.game.domain.models;

import lombok.Data;

public @Data class Game {
    private long id;
    private Player player;

    public Game() {}

    public Game(long id) {
        this.id = id;
    }

    public Game(long id, Player player) {
        this.id = id;
        this.player = player;
    }
}
