package com.hu.lingoapp.game.application.services;

import com.hu.lingoapp.game.domain.dao.GameDao;
import com.hu.lingoapp.game.domain.models.Game;
import com.hu.lingoapp.game.domain.models.Player;
import com.hu.lingoapp.game.domain.models.Word;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class GameServiceTest {
    @Mock
    private PlayerService playerService;

    @Mock
    private WordService wordService;

    @Mock
    private GameDao gameDao;

    @InjectMocks
    @Resource
    private GameService service = new GameService();

    @Test
    void check_that_no_game_exists() {
        Game game = service.game;
        assertNull(game);
    }

    @Test
    void create_new_game() {
        //TODO find other solution
        MockitoAnnotations.initMocks(this);

        Player player = new Player(0);
        Word answer = new Word("pizza");
        Game game = new Game(0, player, answer);

        when(playerService.save(new Player())).thenReturn(player);
        when(wordService.chooseRandomWord()).thenReturn(answer);
        when(gameDao.save(game)).thenReturn(game);

        boolean accepts = service.newGame();
        assertTrue(accepts);
    }

    @Test
    void check_that_game_exists() {
        Game game = service.game;
        assertNotNull(game);
    }

    @Test
    void win_a_game() {
        //when(g)

        boolean accepts = service.win();
        assertTrue(accepts);
    }

}