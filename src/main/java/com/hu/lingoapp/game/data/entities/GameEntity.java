package com.hu.lingoapp.game.data.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "games")
public @Data
class GameEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="player_id")
    private PlayerEntity player;

    public GameEntity() {}

    public GameEntity(Long id) {
        this.id = id;
    }
}
