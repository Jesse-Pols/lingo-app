package com.hu.lingoapp.game.application.services;

import com.hu.lingoapp.game.domain.models.Game;
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
        // Check every letter in the word and the answer

        if (!this.verificationService.verify(word)) { return null; }

        String answer = gameService.getCurrentGameAnswer();
        if (answer == null) return null;

        if (word.equals(answer)) { gameService.win(); }
        return this.checkLetters(word, answer);
    }

    public List<Letter> checkLetters(String word, String answer) {
        List<Letter> letters = new ArrayList<>();
        // Check for every letter if the letter is present in the word

        for (int i = 0; i < word.length(); i++) {
            Letter letter = this.checkLetter(word, answer, i);
            letters.add(letter);
        }

        return letters;
    }

    public Letter checkLetter(String word, String answer, int i) {
        if (word == null || answer == null || i < 0) return null;
        Letter letter = new Letter(i, null, false, false);

        char w;
        try {
            w = word.charAt(i);
            letter.setLetter(String.valueOf(w));
        } catch (StringIndexOutOfBoundsException e) {
            e.printStackTrace();
            return letter;
        }

        if (answer.contains(letter.getLetter())) { letter.setPresent(true); }
        else { return letter; }

        char a;
        try {
            a = answer.charAt(i);
            if (a == w) { letter.setCorrect(true); }
        } catch (StringIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        return letter;
    }

}
