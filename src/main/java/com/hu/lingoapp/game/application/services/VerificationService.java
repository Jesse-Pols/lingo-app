package com.hu.lingoapp.game.application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class VerificationService {

    @Autowired
    private GameService gameService;

    public boolean verify(String word) {
        LocalDateTime localDateTime = gameService.getTimeOfLastGuess();
        if (localDateTime == null) { localDateTime = gameService.getStartTime(); }
        if (localDateTime == null) { return false; }
        if (word == null) { return false; }
        return this.verifyRegex(word);
    }

    public boolean verifyRegex(String word) {
        return word.matches("^[a-z]{5,7}$");
    }

    public boolean verifyTimer(LocalDateTime dateTime) {
        return !dateTime.isBefore(LocalDateTime.now().minusSeconds(10));
    }

}
