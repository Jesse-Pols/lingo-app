package com.hu.lingoapp.game.application.services;

import com.hu.lingoapp.game.domain.dao.GameDao;
import com.hu.lingoapp.game.domain.dao.PlayerDao;
import com.hu.lingoapp.game.domain.models.Game;
import com.hu.lingoapp.game.domain.models.Player;
import com.hu.lingoapp.game.domain.models.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class GameService {

    @Autowired
    private GameDao gameDao;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private WordService wordService;

    @Autowired
    private PlayerDao playerDao;

    // Game contains the answer, the score, the current turn, and which player is playing
    public Game game;

    public boolean newGame(int answerLength) {
        Game game = new Game();
        Player player = playerService.save(new Player());
        if (player == null) return false;
        game.setPlayer(player);

        Word answer = wordService.chooseRandomWord(answerLength);
        if (answer == null) return false;
        game.setAnswer(answer);

        game.setTimeStarted(LocalDateTime.now());
        this.game = gameDao.save(game);
        return (this.game != null);
    }

    public boolean finishGame(boolean won) throws Exception {
        if (game == null) throw new Exception("Game could not be found, try creating a new game.");

        Player player = game.getPlayer();
        if (player == null) throw new Exception("Game did not contain a player. Something must have gone wrong when creating a new game.");

        game.setTimeEnded(LocalDateTime.now());

        if (won) {
            player.setScore(player.getScore() + 1);
            game.setPlayer(player);
            this.setGame(game);
        }

        return true;
    }

    public boolean endGame(String name) throws Exception {
        if (game == null) throw new Exception("Game could not be found, try creating a new game.");

        Player player = game.getPlayer();
        if (player == null) throw new Exception("Game did not contain a player. Something must have gone wrong when creating a new game.");

        finishGame(false);
        player.setName(name);
        game.setPlayer(player);

        return setGame(game);
    }

    public boolean nextGame(boolean gameWon) throws Exception {
        finishGame(gameWon);
        return newGame(5);
    }

    // If the player has been altered, than that must be saved locally as well as in the db
    // Which is why we don't have a separate setPlayer method. We need this together.
    public boolean setGame(Game game) {
        if (game != null) gameDao.save(game);
        this.game = game;

        Player newPlayer = game.getPlayer();
        if (newPlayer != null) playerDao.save(newPlayer);

        return true;
    }
}
