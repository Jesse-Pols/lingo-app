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
public class PlayerConverter {
    @Autowired
    GameConverter gameConverter;

    public Player convertEntityToModel(PlayerEntity entity) {
        Player model = new Player();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setScore(entity.getScore());

        List<Game> gameModels = gameConverter.convertEntitiesToModels(entity.getGames());
        model.setGames(gameModels);

        return model;
    }

    public List<Player> convertEntitiesToModels(List<PlayerEntity> entities) {
        List<Player> models = new ArrayList<>();
        for (PlayerEntity entity : entities) {
            Player model = this.convertEntityToModel(entity);
            models.add(model);
        }
        return models;
    }

    public PlayerEntity convertModelToEntity(Player model) {
        PlayerEntity entity = new PlayerEntity();
        entity.setId(model.getId());
        entity.setName(model.getName());
        entity.setScore(model.getScore());

        List<GameEntity> gameEntities = gameConverter.convertModelsToEntities(model.getGames());
        entity.setGames(gameEntities);

        return entity;
    }

    public List<PlayerEntity> convertModelsToEntities(List<Player> models) {
        List<PlayerEntity> entities = new ArrayList<>();
        for (Player model : models) {
            PlayerEntity entity = this.convertModelToEntity(model);
            entities.add(entity);
        }
        return entities;
    }
}
