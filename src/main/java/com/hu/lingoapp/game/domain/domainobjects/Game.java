package com.hu.lingoapp.game.domain.domainobjects;

import lombok.Data;

public @Data class Game {
    private Long id;
    private Player player;

    public Game() {}

    public Game(Long id) {
        this.id = id;
    }

    public Game(Long id, Player player) {
        this.id = id;
        this.player = player;
    }
}
