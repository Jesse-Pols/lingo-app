package com.hu.lingoapp.game.presentation.controllers;

import com.hu.lingoapp.game.application.services.GuessService;
import com.hu.lingoapp.game.domain.models.Letter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("guess")
public class GuessController {
    @Autowired
    private GuessService guessService;

    @PostMapping
    @ResponseBody
    public List<Letter> guess(@RequestParam String word) {
        return guessService.guess(word);
    }
}
