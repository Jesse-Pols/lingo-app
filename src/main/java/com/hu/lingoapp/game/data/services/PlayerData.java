package com.hu.lingoapp.game.data.services;

import com.hu.lingoapp.game.data.entities.PlayerEntity;

import java.util.List;

public interface PlayerData {
    List<PlayerEntity> findAll();
}
