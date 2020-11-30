package com.hu.lingoapp.game.data.dao;

import com.hu.lingoapp.game.data.entities.PlayerEntity;
import com.hu.lingoapp.game.data.repositories.PlayerRepository;
import com.hu.lingoapp.game.domain.dao.PlayerDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PlayerDaoService implements PlayerDao {
    @Autowired
    private PlayerRepository repository;

    @Override
    public List<PlayerEntity> findAll() {
        return (List<PlayerEntity>) repository.findAll();
    }
}
