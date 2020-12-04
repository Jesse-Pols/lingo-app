package com.hu.lingoapp.game.domain.dao.converters;

import com.hu.lingoapp.game.data.entities.GameEntity;
import com.hu.lingoapp.game.domain.domainobjects.Game;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameConverter {
    public Game convertEntityToModel(GameEntity entity) {
        Game model = new Game();
        model.setId(entity.getId());
        // TODO: Set player

        return model;
    }

    public List<Game> convertEntitiesToModels(List<GameEntity> entities) {
        List<Game> models = new ArrayList<>();
        for (GameEntity entity : entities) {
            Game model = this.convertEntityToModel(entity);
            models.add(model);
        }
        return models;
    }

    public GameEntity convertModelToEntity(Game model) {
        GameEntity entity = new GameEntity();
        entity.setId(model.getId());
        // TODO: Set player

        return entity;
    }

    public List<GameEntity> convertModelsToEntities(List<Game> models) {
        List<GameEntity> entities = new ArrayList<>();
        for (Game model : models) {
            GameEntity entity = this.convertModelToEntity(model);
            entities.add(entity);
        }
        return entities;
    }
}
