package com.hu.lingoapp.game.data.services;

import com.hu.lingoapp.game.data.dtos.PlayerDto;

import java.util.List;

public interface PlayerData {
    List<PlayerDto> findAll();
}
