package com.hu.lingoapp.game.data.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "players")
public class PlayerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // TODO: Foreign Relation
    //@OneToMany
    //private Set<GameEntity> games;


    private String name;
    private int score;

    public PlayerEntity() {}
}