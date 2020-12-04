package com.hu.lingoapp.game.domain._dao;

import com.hu.lingoapp.game.data.entities.PlayerEntity;

import java.util.List;

public interface PlayerDao {
    List<PlayerEntity> findAll();
}
