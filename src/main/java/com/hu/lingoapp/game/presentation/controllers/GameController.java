package com.hu.lingoapp.game.presentation.controllers;

import com.hu.lingoapp.game.business.services.GameService;
import com.hu.lingoapp.game.business.services.iGameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/game")
public class GameController implements iGameController {

    iGameService gameService = new GameService();

    @GetMapping("/new")
    public boolean newGame() {
        return gameService.newGame();
    }

}
