package com.hu.lingoapp.game.presentation.controllers;

import com.hu.lingoapp.game.application.services.GameService;
import com.hu.lingoapp.game.domain.models.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("game")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/get/current")
    @ResponseBody
    public Game getCurrentGame() {
        if (gameService.game == null) return null;
        return gameService.game;
    }

    @PostMapping("/new")
    @ResponseBody
    public boolean newGame() {
        return gameService.newGame();
    }

}
