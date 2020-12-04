package com.hu.lingoapp.game.data.dtos;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "players")
public @Data
class PlayerDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int score;

    public PlayerDto() {}
}