package com.hu.lingoapp.game.domain.dao.converters;

import com.hu.lingoapp.game.data.dtos.GameDto;
import com.hu.lingoapp.game.domain.dao.services.PlayerDaoService;
import com.hu.lingoapp.game.domain.models.Game;
import com.hu.lingoapp.game.domain.models.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameConverter {

    @Autowired
    PlayerDaoService playerDaoService;

    public Game convertEntityToModel(GameDto entity) {
        Game model = new Game();
        model.setId(entity.getId());

        try {
            Long id = entity.getPlayer_id();
            if (id != null)  { Player player = playerDaoService.findById(id);
            model.setPlayer(player); }
        } catch (Exception e) {
            e.printStackTrace();
        }

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

        try {
            entity.setPlayer_id(model.getPlayer().getId());
        } catch (Exception e) {
            e.printStackTrace();
        }

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
