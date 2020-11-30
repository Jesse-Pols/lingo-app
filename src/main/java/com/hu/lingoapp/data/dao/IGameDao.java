package com.hu.lingoapp.data.dao;

import com.hu.lingoapp.data.entities.GameEntity;

import java.util.List;

public interface IGameDao {
    List<GameEntity> findAll();
}
