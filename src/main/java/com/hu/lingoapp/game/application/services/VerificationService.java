package com.hu.lingoapp.game.application.services;

import org.springframework.stereotype.Service;

@Service
public class VerificationService {

    public boolean verify(String word) {
        if (!this.verifyRegex(word)) { return false; }
        if (!this.verifyTimer()) { return false; }
        return true;
    }

    public boolean verifyRegex(String word) {
        return word.matches("^[a-z]{5,7}$");
    }

    public boolean verifyTimer() {
        return true;
    }

    

}
