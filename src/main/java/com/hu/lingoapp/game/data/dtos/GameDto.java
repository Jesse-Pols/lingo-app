package com.hu.lingoapp.game.data.dtos;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "games")
public @Data
class GameDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="player_id")
    private int player_id;

    public GameDto() {}

    public GameDto(Long id) {
        this.id = id;
    }
}
