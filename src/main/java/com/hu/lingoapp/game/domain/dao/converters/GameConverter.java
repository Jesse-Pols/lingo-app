package com.hu.lingoapp.game.domain.dao.converters;

import com.hu.lingoapp.game.data.entities.GameEntity;
import com.hu.lingoapp.game.data.entities.PlayerEntity;
import com.hu.lingoapp.game.domain.domainobjects.Game;
import com.hu.lingoapp.game.domain.domainobjects.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameConverter {
    @Autowired
    PlayerConverter playerConverter;

    public Game convertEntityToModel(GameEntity entity) {
        Game model = new Game();
        model.setId(entity.getId());

        PlayerEntity playerEntity = entity.getPlayer();
        if (playerEntity != null) {
            Player playerModel = playerConverter.convertEntityToModel(entity.getPlayer());
            model.setPlayer(playerModel);
        }

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

        Player playerModel = model.getPlayer();
        if (playerModel != null) {
            PlayerEntity playerEntity = playerConverter.convertModelToEntity(model.getPlayer());
            entity.setPlayer(playerEntity);
        }

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
