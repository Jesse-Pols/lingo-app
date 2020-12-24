package com.hu.lingoapp.game.presentation.controllers;

import com.hu.lingoapp.game.application.services.GameService;
import com.hu.lingoapp.game.domain.models.Game;
import com.hu.lingoapp.game.domain.models.Letter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public boolean newGame(@RequestParam int answerLength) {
        return gameService.newGame(answerLength);
    }

    @GetMapping("/get/guessed")
    @ResponseBody
    public List<Letter> getGuessedLetters() {
        return gameService.game.getGuessedLetters();
    }

}
