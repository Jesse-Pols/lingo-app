package com.hu.lingoapp.game.application.services;

import com.hu.lingoapp.game.data.dao.GameDaoService;
import com.hu.lingoapp.game.domain.dao.GameDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    @Autowired
    private GameDaoService gameDao;

    public String getAllGames() {
        // With every new game, a new player is also created
        // During the game this player consists only of an ID, at the end the player gets a name and a score

        gameDao.findAll();
        return "Done";

    }
}
