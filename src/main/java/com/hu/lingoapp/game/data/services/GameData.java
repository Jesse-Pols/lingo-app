package com.hu.lingoapp.game.data.services;

import com.hu.lingoapp.game.data.dtos.GameDto;

import java.util.List;

public interface GameData {
    List<GameDto> findAll();
}
