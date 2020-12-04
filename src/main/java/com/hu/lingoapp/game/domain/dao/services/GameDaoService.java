package com.hu.lingoapp.game.domain.dao.services;

import com.hu.lingoapp.game.data.entities.GameEntity;
import com.hu.lingoapp.game.data.services.GameData;
import com.hu.lingoapp.game.domain.dao.GameDao;
import com.hu.lingoapp.game.domain.dao.converters.GameConverter;
import com.hu.lingoapp.game.domain.domainobjects.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameDaoService implements GameDao {
    @Autowired
    GameData data;

    @Autowired
    GameConverter converter;

    public List<Game> findAll() {
        List<GameEntity> gameEntities = data.findAll();
        return converter.convertEntitiesToModels(gameEntities);
    }
}
