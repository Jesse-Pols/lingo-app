package com.hu.lingoapp.domain.dao;

import com.hu.lingoapp.data.entities.GameEntity;

import java.util.List;

public interface GameDao {
    List<GameEntity> findAll();
}
