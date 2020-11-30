package com.hu.lingoapp.game.data.entities;

import javax.persistence.*;

@Entity
@Table(name = "games")
public class GameEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int player_id;

    public GameEntity() {}

    public Long getId() {
        return this.id;
    }
}
