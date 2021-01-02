package com.hu.lingoapp.game.presentation.controllers;

import com.hu.lingoapp.game.application.services.GameService;
import com.hu.lingoapp.game.domain.models.Game;
import com.hu.lingoapp.game.domain.models.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;

class GameControllerTest {

    @Mock
    private GameService gameService;

    @InjectMocks
    @Resource
    private GameController gameController;

    @BeforeEach
    void beforeEach() {
        gameController = new GameController();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void get_current_game_without_first_creating_a_game() {
        var accepts = gameController.getCurrentGame();
        assertEquals(accepts.getStatusCode(), BAD_REQUEST);
    }

    @Test
    void get_current_game_with_a_present_game() {
        gameService.game = new Game();

        var accepts = gameController.getCurrentGame();
        assertEquals(accepts.getStatusCode(), OK);
    }

    @Test
    void new_game() {
        when(gameService.newGame(5)).thenReturn(true);
        assertTrue(gameController.newGame(5));
    }





}