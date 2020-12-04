package com.hu.lingoapp.game.domain.dao.converters;

import com.hu.lingoapp.game.data.dtos.GameDto;
import com.hu.lingoapp.game.data.dtos.PlayerDto;
import com.hu.lingoapp.game.domain.models.Game;
import com.hu.lingoapp.game.domain.models.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameConverter {
    @Autowired
    PlayerConverter playerConverter;

    public Game convertEntityToModel(GameDto entity) {
        Game model = new Game();
        model.setId(entity.getId());
        model.setPlayer_id(entity.getPlayer_id());

        return model;
    }

    public List<Game> convertEntitiesToModels(List<GameDto> entities) {
        List<Game> models = new ArrayList<>();
        for (GameDto entity : entities) {
            Game model = this.convertEntityToModel(entity);
            models.add(model);
        }
        return models;
    }

    public GameDto convertModelToEntity(Game model) {
        GameDto entity = new GameDto();
        entity.setId(model.getId());
        entity.setPlayer_id(model.getPlayer_id());

        return entity;
    }

    public List<GameDto> convertModelsToEntities(List<Game> models) {
        List<GameDto> entities = new ArrayList<>();
        for (Game model : models) {
            GameDto entity = this.convertModelToEntity(model);
            entities.add(entity);
        }
        return entities;
    }
}
