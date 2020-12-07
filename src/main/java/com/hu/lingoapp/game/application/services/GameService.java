package com.hu.lingoapp.game.application.services;

import com.hu.lingoapp.game.domain.dao.GameDao;
import com.hu.lingoapp.game.domain.dao.PlayerDao;
import com.hu.lingoapp.game.domain.models.Game;
import com.hu.lingoapp.game.domain.models.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameDao gameDao;

    // TODO: Should this class reference the PlayerService, or directly call the PlayerDao?
    @Autowired
    private PlayerDao playerDao;

    public List<Game> getAllGames() {
        return gameDao.findAll();
    }

    public Game newGame() {
        // Every new game gets a new player
        Game game = new Game();
        Player player = new Player();


        return gameDao.save(game);

    }
}
