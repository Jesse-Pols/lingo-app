package com.hu.lingoapp.game.domain.dao.services;

import com.hu.lingoapp.game.data.dtos.GameDto;
import com.hu.lingoapp.game.data.services.GameData;
import com.hu.lingoapp.game.domain.dao.converters.GameConverter;
import com.hu.lingoapp.game.domain.models.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class GameDaoServiceTest {

    @Mock
    private GameData data;

    @Mock
    private GameConverter converter;

    @InjectMocks
    @Resource
    private GameDaoService gameDaoService;

    @BeforeEach
    void setUp() {
        gameDaoService = new GameDaoService();
        //TODO find other solution
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void find_all_games() {
        when(data.findAll()).thenReturn(new ArrayList<>());
        when(converter.convertEntitiesToModels(any())).thenReturn(new ArrayList<>());
        List<Game> list =  gameDaoService.findAll();
        assertNotNull(list);
    }

    @Test
    void save_game_to_db() {
        when(converter.convertModelToEntity(new Game())).thenReturn(new GameDto());
        when(data.save(new GameDto())).thenReturn(new GameDto(1));
        when(converter.convertEntityToModel(new GameDto(1))).thenReturn(new Game(1));

        Game game = gameDaoService.save(new Game());
        assertNotNull(game);
        assertEquals(game.getId(), 1);
    }
}