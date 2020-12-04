package com.hu.lingoapp.game.domain.dao;

import com.hu.lingoapp.game.domain.models.Game;

import java.util.List;

public interface GameDao {
    List<Game> findAll();
}
