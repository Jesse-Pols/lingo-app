package com.hu.lingoapp.game.domain.dao.services;

import com.hu.lingoapp.game.data.dtos.GameDto;
import com.hu.lingoapp.game.data.services.GameData;
import com.hu.lingoapp.game.domain.dao.GameDao;
import com.hu.lingoapp.game.domain.dao.converters.GameConverter;
import com.hu.lingoapp.game.domain.models.Game;
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
        List<GameDto> gameDtos = data.findAll();
        return converter.convertEntitiesToModels(gameDtos);
    }
}
