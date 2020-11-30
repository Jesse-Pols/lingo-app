package com.hu.lingoapp.game.data.dao;

import com.hu.lingoapp.game.data.entities.GameEntity;
import com.hu.lingoapp.game.data.repositories.GameRepository;
import com.hu.lingoapp.game.domain.dao.GameDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameDaoService implements GameDao {
    @Autowired
    private GameRepository repository;

    @Override
    public List<GameEntity> findAll() {
        return (List<GameEntity>) repository.findAll();
    }
}
