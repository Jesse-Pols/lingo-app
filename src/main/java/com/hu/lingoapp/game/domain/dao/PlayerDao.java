package com.hu.lingoapp.game.domain.dao;

import com.hu.lingoapp.game.domain.domainobjects.Player;

import java.util.List;

public interface PlayerDao {
    List<Player> findAll();
}