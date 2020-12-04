package com.hu.lingoapp.game.data.services.implementations;

import com.hu.lingoapp.game.data.services.PlayerData;
import com.hu.lingoapp.game.data.entities.PlayerEntity;
import com.hu.lingoapp.game.data.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerDataService implements PlayerData {
    @Autowired
    private PlayerRepository repository;

    @Override
    public List<PlayerEntity> findAll() {
        return (List<PlayerEntity>) repository.findAll();
    }
}
