package com.hu.lingoapp.game.domain.dao;

import com.hu.lingoapp.game.domain.domainobjects.Game;

import java.util.List;

public interface GameDao {
    List<Game> findAll();
}
