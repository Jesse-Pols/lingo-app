package com.hu.lingoapp.game.domain.dao;

import com.hu.lingoapp.game.data.entities.GameEntity;

import java.util.List;

public interface GameDao {
    List<GameEntity> findAll();
}
