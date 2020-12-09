package com.hu.lingoapp.game.application.services;

import com.hu.lingoapp.game.domain.dao.PlayerDao;
import com.hu.lingoapp.game.domain.models.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerDao dao;

    private Player player;

    public List<Player> getAllPlayers() {
        return dao.findAll();
    }

    public Player save(Player player) {
        return dao.save(player);
    }

}
