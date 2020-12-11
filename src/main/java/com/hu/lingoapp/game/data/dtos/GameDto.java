package com.hu.lingoapp.game.data.dtos;

import lombok.Data;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Table(name = "games")
public @Data
class GameDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long player_id;
    private long answer_id;
    private Timestamp start_time;
    private Timestamp end_time;
    private Timestamp last_guess;

    public GameDto() {}

    public GameDto(long id) {
        this.id = id;
    }

    public GameDto(long id, long player_id) {
        this.id = id;
        this.player_id = player_id;
    }
}
