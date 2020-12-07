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
    private Long player_id;

    public GameDto() {}

    public GameDto(Long id) {
        this.id = id;
    }

    public GameDto(Long id, Long player_id) {
        this.id = id;
        this.player_id = player_id;
    }
}
