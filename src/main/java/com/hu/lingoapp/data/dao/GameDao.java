package com.hu.lingoapp.data.dao;

import com.hu.lingoapp.data.entities.GameEntity;
import com.hu.lingoapp.data.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameDao implements IGameDao {
    @Autowired
    private GameRepository repository;

    @Override
    public List<GameEntity> findAll() {
        return (List<GameEntity>) repository.findAll();
    }
}
