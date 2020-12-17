package com.hu.lingoapp.game.presentation.controllers;

import com.hu.lingoapp.game.application.services.GuessService;
import com.hu.lingoapp.game.domain.models.Letter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("guess")
public class GuessController {
    @Autowired
    private GuessService guessService;

    @PostMapping
    @ResponseBody
    public ResponseEntity guess(@RequestParam String word) {
        List<Letter> list;
        try {
            list = guessService.guess(word);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

        if (list != null) return ResponseEntity.ok(list);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something went wrong, the server returned null.");
    }
}
