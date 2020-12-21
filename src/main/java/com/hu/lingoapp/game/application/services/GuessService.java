package com.hu.lingoapp.game.application.services;

import com.hu.lingoapp.game.domain.models.Game;
import com.hu.lingoapp.game.domain.models.Letter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class GuessService {

    @Autowired
    private GameService gameService;

    @Autowired
    private VerificationService verificationService;

    @Autowired
    private TurnService turnService;

    public List<Letter> guess(String word) throws Exception {
        // Verify the guessed word, and perform null-checks
        // Check if the player has won
        // Add 1 to the current turn, or finish the game (if we are at the fifth turn)
        // Return a list of letters, based on which letters in the guessed word were correct, absent or present

        Game game = gameService.game;
        if (game == null) throw new Exception("No game was found. Please start by creating a new game.");
        if (game.getAnswerString() == null) throw new Exception("The current game does not contain an answer");

        boolean verified = verificationService.verifyGuess(word, game.getTimeLastGuess());
        if (!verified) throw new Exception("The guessed word could not be verified.");

        if (game.getAnswerString().equals(word)) gameService.finishGame(true);
        if (game.getTurn() >= 5) gameService.finishGame(false);

        turnService.nextTurn();
        return this.checkLetters(word, game.getAnswerString());
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

        // Get the exact letter from the word
        char w;
        try {
            w = word.charAt(i);
            letter.setLetter(String.valueOf(w));
        } catch (StringIndexOutOfBoundsException e) {
            e.printStackTrace();
            return letter;
        }

        // Check if the letter is present in the answer
        if (answer.contains(letter.getLetter())) { letter.setPresent(true); }
        else { return letter; }

        // Check if the letter's location is exactly right in the answer
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
