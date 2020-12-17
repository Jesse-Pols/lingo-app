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
        game.setPlayer(player);

        Word answer = wordService.chooseRandomWord();
        if (answer == null) return false;
        game.setAnswer(answer);

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

    public String getCurrentGameAnswer() throws Exception {
        if (game == null) throw new Exception("Game couldn't be found. Please try creating a new game first.");
        Word answerObj = game.getAnswer();

        if (answerObj == null) throw new Exception("Something went wrong, the game doesn't have an answer.");
        return answerObj.getText();
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
