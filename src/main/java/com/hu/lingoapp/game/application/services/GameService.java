package com.hu.lingoapp.game.application.services;

import com.hu.lingoapp.game.domain.dao.GameDao;
import com.hu.lingoapp.game.domain.models.Game;
import com.hu.lingoapp.game.domain.models.Player;
import com.hu.lingoapp.game.domain.models.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameDao gameDao;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private WordService wordService;

    public List<Game> getAllGames() {
        return gameDao.findAll();
    }

    public Game newGame() {
        // Every new game gets a new player
        Game game = new Game();
        Player player = new Player();

        player = playerService.save(player);
        game.setPlayer(player);

        Word answer = wordService.chooseRandomWord();

        return gameDao.save(game);
    }
}
