package com.hu.lingoapp.game.application.services;

import com.hu.lingoapp.game.domain.dao.GameDao;
import com.hu.lingoapp.game.domain.dao.PlayerDao;
import com.hu.lingoapp.game.domain.models.Game;
import com.hu.lingoapp.game.domain.models.Player;
import com.hu.lingoapp.game.domain.models.Word;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class GameServiceTest {

    @Mock
    private PlayerService playerService;

    @Mock
    private WordService wordService;

    @Mock
    private GameDao gameDao;

    @Mock
    private PlayerDao playerDao;

    @InjectMocks
    @Resource
    private GameService gameService;

    @BeforeEach
    void beforeEach() {
        gameService = new GameService();
        //TODO find other solution
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void create_a_new_game() {
        when(playerService.save(new Player())).thenReturn(new Player());
        when(wordService.chooseRandomWord(6)).thenReturn(new Word("word"));
        when(gameDao.save(any())).thenReturn(new Game());

        assertTrue(gameService.newGame(6));
    }

    @Test
    void finish_won_game_and_continue_to_next_game() throws Exception {
        gameService.game = new Game(0, new Player(0), new Word("pizza"));

        when(gameDao.save(any())).thenReturn(new Game());
        when(playerDao.save(any())).thenReturn(new Player());

        assertTrue(gameService.finishGame(true));
    }

    @Test
    void finish_lost_game_and_continue_to_next_game() throws Exception {
        gameService.game = new Game(0, new Player(0), new Word("pizza"));
        assertTrue(gameService.finishGame(false));
    }

    @Test
    void end_game() throws Exception {
        gameService.game = new Game(0, new Player(0), new Word("pizza"));

        when(gameDao.save(any())).thenReturn(new Game());
        when(playerDao.save(any())).thenReturn(new Player());

        assertTrue(gameService.endGame("don cheadle"));
    }

    @Test
    void next_game() throws Exception {
        gameService.game = new Game(0, new Player(0), new Word("pizza"));

        // finishgame calls setGame
        when(gameDao.save(any())).thenReturn(new Game());
        when(playerDao.save(any())).thenReturn(new Player());

        when(playerService.save(new Player())).thenReturn(new Player(0));
        when(wordService.chooseRandomWord(5)).thenReturn(new Word("pizza"));

        assertTrue(gameService.nextGame(true));
    }

}