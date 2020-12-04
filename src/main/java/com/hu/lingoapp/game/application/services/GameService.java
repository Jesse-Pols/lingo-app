package com.hu.lingoapp.game.application.services;

import com.hu.lingoapp.game.domain.dao.GameDao;
import com.hu.lingoapp.game.domain.domainobjects.Game;
import com.hu.lingoapp.game.domain.domainobjects.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameDao dao;

    public List<Game> getAllGames() {
        return dao.findAll();
    }

    public Game newGame() {
        // Every new game gets a new player
        Game game = new Game();
        game.setPlayer(new Player());

        return game;

    }
}
