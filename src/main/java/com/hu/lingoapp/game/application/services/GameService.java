package com.hu.lingoapp.game.application.services;

import com.hu.lingoapp.game.domain.dao.GameDao;
import com.hu.lingoapp.game.domain.models.Game;
import com.hu.lingoapp.game.domain.models.Player;
import com.hu.lingoapp.game.domain.models.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameDao gameDao;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private WordService wordService;

    // Game contains the answer, the score, the current turn, and which player is playing
    public Game game;

    public boolean newGame() {
        Game game = new Game();
        Player player = playerService.save(new Player());
        if (player == null) return false;

        Word answer = wordService.chooseRandomWord();
        if (answer == null) return false;

        game.setTimeStarted(LocalDateTime.now());
        this.game = gameDao.save(game);
        return (this.game != null);
    }

    public boolean setTimeOfLastGuess(LocalDateTime time) {
        if (game == null) return false;
        game.setTimeLastGuess(time);

        gameDao.save(game);
        return true;
    }

    public String getCurrentGameAnswer() {
        if (game == null) return null;
        Word answerObj = game.getAnswer();

        if (answerObj == null) return null;
        String answer = answerObj.getText();

        return answer;
    }

    public boolean win() {
        // set player score
        // set end time
        // set game to won (?)
        System.out.println("You Won!");

        game.setTimeEnded(LocalDateTime.now());
        gameDao.save(game);

        return true;
    }

    public boolean setPlayerName(String name) {
        Player player = game.getPlayer();
        if (player == null) return false;

        player.setName(name);
        playerService.save(player);
        return true;
    }
}
