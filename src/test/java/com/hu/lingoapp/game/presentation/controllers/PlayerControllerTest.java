package com.hu.lingoapp.game.presentation.controllers;

import com.hu.lingoapp.game.application.services.PlayerService;
import com.hu.lingoapp.game.domain.models.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class PlayerControllerTest {

    @Mock
    private PlayerService playerService;

    @InjectMocks
    @Resource
    private PlayerController playerController;

    @BeforeEach
    void beforeEach() {
        playerController = new PlayerController();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void get_all_players() {
        when(playerService.getAllPlayers()).thenReturn(new ArrayList<>());
        List<Player> players = playerController.getAllPlayers();
        assertEquals(players, new ArrayList<>());
    }
}