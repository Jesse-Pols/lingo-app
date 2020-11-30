package com.hu.lingoapp.data.entities;

import javax.persistence.*;

@Entity
@Table(name = "game")
public class GameEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public GameEntity() {}

    public GameEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
