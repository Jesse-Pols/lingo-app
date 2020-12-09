package com.hu.lingoapp.game.application.services;

import com.hu.lingoapp.game.domain.models.Letter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GuessService {

    @Autowired
    private GameService gameService;

    @Autowired
    private VerificationService verificationService;

    public List<Letter> guess(String word) {
        // Verify the word
        // Check if the letters are present
        // Check if the letters are in the right place

        String answer = gameService.getCurrentGameAnswer();
        if (answer == null) return null;

        if (!this.verificationService.verify(word)) { return null; }
        return this.checkLetters(word, answer);
    }

    public List<Letter> checkLetters(String word, String answer) {
        List<Letter> letters = new ArrayList<>();
        // Check for every letter if the letter is present in the word

        for (int i = 0; i < word.length(); i++) {
            char wordChar = word.charAt(i);
            Letter letter = new Letter(i, wordChar, false, false);

            if (answer.indexOf(wordChar) != 0) { letter.setPresent(true); }
            if (i == answer.indexOf(wordChar)) { letter.setCorrect(true); }

            letters.add(letter);
        }

        return letters;
    }

}
