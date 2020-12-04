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
public class PlayerConverter {
    @Autowired
    GameConverter gameConverter;

    public Player convertEntityToModel(PlayerDto entity) {
        Player model = new Player();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setScore(entity.getScore());

        return model;
    }

    public List<Player> convertEntitiesToModels(List<PlayerDto> entities) {
        List<Player> models = new ArrayList<>();
        for (PlayerDto entity : entities) {
            Player model = this.convertEntityToModel(entity);
            models.add(model);
        }
        return models;
    }

    public PlayerDto convertModelToEntity(Player model) {
        PlayerDto entity = new PlayerDto();
        entity.setId(model.getId());
        entity.setName(model.getName());
        entity.setScore(model.getScore());

        return entity;
    }

    public List<PlayerDto> convertModelsToEntities(List<Player> models) {
        List<PlayerDto> entities = new ArrayList<>();
        for (Player model : models) {
            PlayerDto entity = this.convertModelToEntity(model);
            entities.add(entity);
        }
        return entities;
    }
}
