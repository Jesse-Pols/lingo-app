package com.hu.lingoapp.game.application.services;

import com.hu.lingoapp.game.domain.dao.GameDao;
import com.hu.lingoapp.game.domain.dao.PlayerDao;
import com.hu.lingoapp.game.domain.models.Game;
import com.hu.lingoapp.game.domain.models.Player;
import com.hu.lingoapp.game.domain.models.Word;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.annotation.Resource;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void create_a_new_game() {
        when(playerService.save(new Player())).thenReturn(new Player());
        when(wordService.chooseRandomWord(6)).thenReturn(new Word("word"));
        when(gameDao.save(any())).thenReturn(new Game());

        assertTrue(gameService.newGame(6));
    }

    @ParameterizedTest
    @MethodSource("provideWonFailedAndUnfinishedGames")
    void finish_game(Game game) {
        gameService.game = game;

        when(gameDao.save(any())).thenReturn(new Game());
        when(playerDao.save(any())).thenReturn(new Player());

        assertTrue(gameService.finishGame("name"));
    }

    static Stream<Arguments> provideWonFailedAndUnfinishedGames() {
        return Stream.of(
                Arguments.of(new Game(new Player(0), true, true)),
                Arguments.of(new Game(new Player(0), false, false)),
                Arguments.of(new Game(new Player(0), true, false)),
                Arguments.of(new Game(new Player(0), false, true))
        );
    }



}