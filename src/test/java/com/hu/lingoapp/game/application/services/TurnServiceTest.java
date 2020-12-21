package com.hu.lingoapp.game.application.services;

import com.hu.lingoapp.game.domain.models.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class TurnServiceTest {

    @Mock
    private GameService gameService;

    @InjectMocks
    @Resource
    private TurnService turnService;

    @BeforeEach
    void beforeEach() {
        this.gameService = new GameService();
        //TODO find other solution
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void next_turn() throws Exception {
        gameService.game = new Game();
        when(gameService.setGame(new Game())).thenReturn(true);

        assertTrue(turnService.nextTurn());
    }

}