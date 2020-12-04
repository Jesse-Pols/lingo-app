package com.hu.lingoapp.game.domain.domainobjects;

import lombok.Data;

public @Data class Game {
    Long id;
    Player player;

    public Game() {}

    public Game(Long id) {
        this.id = id;
    }
}
