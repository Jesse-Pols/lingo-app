package com.hu.lingoapp.game.application.services;

import com.hu.lingoapp.game.domain.domainobjects.Game;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    public List<Game> getAllGames() {
        // With every new game, a new player is also created
        // During the game this player consists only of an ID, at the end the player gets a name and a score

        //return gameDao.findAll();
        return null;

    }
}
