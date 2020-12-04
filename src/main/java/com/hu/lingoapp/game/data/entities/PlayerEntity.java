package com.hu.lingoapp.game.data.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "players")
public @Data
class PlayerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy="player")
    private List<GameEntity> games;

    private String name;
    private int score;

    public PlayerEntity() {}
}