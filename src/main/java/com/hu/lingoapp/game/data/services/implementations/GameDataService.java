package com.hu.lingoapp.game.data.services.implementations;

import com.hu.lingoapp.game.data.services.GameData;
import com.hu.lingoapp.game.data.dtos.GameDto;
import com.hu.lingoapp.game.data.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameDataService implements GameData {

    @Autowired
    private GameRepository repository;

    @Override
    public List<GameDto> findAll() {
        List<GameDto> games = (List<GameDto>) repository.findAll();
        return games;
    }
}
