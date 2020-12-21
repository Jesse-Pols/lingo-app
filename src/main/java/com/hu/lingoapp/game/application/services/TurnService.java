package com.hu.lingoapp.game.application.services;

import com.hu.lingoapp.game.domain.models.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TurnService {
    @Autowired
    private GameService gameService;

    public boolean nextTurn() throws Exception {
        Game game = gameService.game;
        if (game == null) throw new Exception("Game could not be found, try creating a new game.");

        game.setTurn(game.getTurn() + 1);
        game.setTimeLastGuess(LocalDateTime.now());

        gameService.setGame(game);
        return true;
    }
}
