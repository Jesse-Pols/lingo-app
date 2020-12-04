package com.hu.lingoapp.game.data.services;

import com.hu.lingoapp.game.data.entities.GameEntity;

import java.util.List;

public interface GameData {
    List<GameEntity> findAll();
}
