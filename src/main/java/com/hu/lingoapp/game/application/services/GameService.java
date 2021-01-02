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
        if (this.game == null) {
            Player player = playerService.save(new Player());
            if (player == null) return false;
            game.setPlayer(player);
        } else {
            game.setPlayer(this.game.getPlayer());
        }

        Word answer = wordService.chooseRandomWord(answerLength);
        if (answer == null) return false;
        game.setAnswer(answer);

        game.setTimeStarted(LocalDateTime.now());
        this.game = gameDao.save(game);
        return (this.game != null);
    }

    // Finishing touches to the last game, sets the end-time and the score
    public boolean finishGame(String name) {
        assert (game != null);
        assert (game.getPlayer() != null);

        Player player = game.getPlayer();
        player.setName(name);
        game.setTimeEnded(LocalDateTime.now());

        // Is the game really finished? If not we can assume that the game is lost.
        if (!game.isFinished()) {
            game.setFinished(true);
            game.setWon(false);
        }

        if (game.isWon()) player.setScore(player.getScore() + 1);

        game.setPlayer(player);
        this.setGame(game);
        return true;
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
