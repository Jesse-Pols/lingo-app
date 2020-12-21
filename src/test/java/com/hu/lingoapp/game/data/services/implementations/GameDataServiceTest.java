package com.hu.lingoapp.game.data.services.implementations;

import com.hu.lingoapp.game.data.dtos.GameDto;
import com.hu.lingoapp.game.data.repositories.GameRepository;
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
import static org.mockito.ArgumentMatchers.any;

class GameDataServiceTest {

    @Mock
    private GameRepository gameRepository;

    @InjectMocks
    @Resource
    private GameDataService gameDataService;

    @BeforeEach
    void setUp() {
        gameDataService = new GameDataService();
        //TODO find other solution
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void save_game_dto() {
        when(gameRepository.save(any())).thenReturn(new GameDto(1));
        GameDto game = gameDataService.save(new GameDto());

        assertNotNull(game);
        assertTrue((game.getId() == 1));
    }

    @Test
    void find_all_games() {
        when(gameRepository.findAll()).thenReturn(new ArrayList<>());
        List<GameDto> list = gameDataService.findAll();
        assertNotNull(list);
    }

}