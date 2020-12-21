package com.hu.lingoapp.game.application.services;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class VerificationService {

    // Words cannot be longer than 7
    // Words cannot be shorter than 5
    // Words have to be lowercase
    // The last guess cant be longer than 10 seconds ago

    public boolean verifyGuess(String answer, LocalDateTime lastGuess) {
        if (!this.verifyRegex(answer)) return false;
        return this.verifyTimer(lastGuess);
    }

    public boolean verifyRegex(String word) {
        if (word == null) return false;
        return word.matches("^[a-z]{5,7}$");
    }

    public boolean verifyTimer(LocalDateTime dateTime) {
        if (dateTime == null) return false;
        return !dateTime.isBefore(LocalDateTime.now().minusSeconds(10));
    }

}
