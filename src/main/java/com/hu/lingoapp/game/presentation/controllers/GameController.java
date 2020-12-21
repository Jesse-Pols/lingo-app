package com.hu.lingoapp.game.presentation.controllers;

import com.hu.lingoapp.game.application.services.GameService;
import com.hu.lingoapp.game.domain.models.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("game")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/get/current")
    @ResponseBody
    public ResponseEntity getCurrentGame() {
        if (gameService.game == null) try {
            throw new Exception("No game was found. Please try creating a new game first.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return ResponseEntity.ok(gameService.game);
    }

    @PostMapping("/new")
    @ResponseBody
    public boolean newGame() {
        return gameService.newGame(5);
    }

}
