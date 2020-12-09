package com.hu.lingoapp.game.application.services;

import com.hu.lingoapp.game.domain.dao.GameDao;
import com.hu.lingoapp.game.domain.models.Game;
import com.hu.lingoapp.game.domain.models.Player;
import com.hu.lingoapp.game.domain.models.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameDao gameDao;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private WordService wordService;

    private Game game;

    public List<Game> getAllGames() {
        return gameDao.findAll();
    }

    public boolean newGame() {
        game = new Game();

        Player player = playerService.save(new Player());
        if (player != null) { game.setPlayer(player); }

        Word answer = wordService.chooseRandomWord();
        if (answer != null) { game.setAnswer(answer); }

        game = gameDao.save(game);
        return true;
    }

    public Game getCurrentGame() {
        return this.game;
    }

    public String getCurrentGameAnswer() {
        if (game == null) return null;
        Word answerObj = game.getAnswer();

        if (answerObj == null) return null;
        String answer = answerObj.getText();

        return answer;
    }
}
