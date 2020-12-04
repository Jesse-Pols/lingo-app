package com.hu.lingoapp.game.presentation.controllers;

import com.hu.lingoapp.game.application.services.GameService;
import com.hu.lingoapp.game.data.entities.GameEntity;
import com.hu.lingoapp.game.domain.domainobjects.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("game")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/get/all")
    @ResponseBody
    public List<Game> getAllGames() {
        return gameService.getAllGames();
    }

    @PostMapping("/new")
    @ResponseBody
    public GameEntity newGame() {
        return null;
    }

}
