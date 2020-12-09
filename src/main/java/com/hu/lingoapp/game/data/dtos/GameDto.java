package com.hu.lingoapp.game.data.dtos;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "games")
public @Data
class GameDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="player_id")
    private long player_id;

    @Column(name="answer_id")
    private long answer_id;

    public GameDto() {}

    public GameDto(long id) {
        this.id = id;
    }

    public GameDto(long id, long player_id) {
        this.id = id;
        this.player_id = player_id;
    }
}
