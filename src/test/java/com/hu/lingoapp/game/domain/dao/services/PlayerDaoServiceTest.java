package com.hu.lingoapp.game.domain.dao.services;

import com.hu.lingoapp.game.data.dtos.GameDto;
import com.hu.lingoapp.game.data.dtos.PlayerDto;
import com.hu.lingoapp.game.data.services.PlayerData;
import com.hu.lingoapp.game.domain.dao.converters.PlayerConverter;
import com.hu.lingoapp.game.domain.models.Game;
import com.hu.lingoapp.game.domain.models.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class PlayerDaoServiceTest {

    @Mock
    private PlayerData data;

    @Mock
    private PlayerConverter converter;

    @InjectMocks
    @Resource
    private PlayerDaoService playerDaoService;

    @BeforeEach
    void setUp() {
        playerDaoService = new PlayerDaoService();
        //TODO find other solution
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void find_all_players() {
        when(data.findAll()).thenReturn(new ArrayList<>());
        when(converter.convertEntitiesToModels(any())).thenReturn(new ArrayList<>());
        List<Player> list =  playerDaoService.findAll();
        assertNotNull(list);
    }

    @Test
    void save_player_to_db() {
        when(converter.convertModelToEntity(new Player())).thenReturn(new PlayerDto());
        when(data.save(new PlayerDto())).thenReturn(new PlayerDto(1));
        when(converter.convertEntityToModel(new PlayerDto(1))).thenReturn(new Player(1));

        Player player = playerDaoService.save(new Player());
        assertNotNull(player);
        assertEquals(player.getId(), 1);
    }

    @Test
    void find_player_by_id() {
        when(data.findById(1l)).thenReturn(Optional.of(new PlayerDto(1)));
        when(converter.convertEntityToModel(new PlayerDto(1l))).thenReturn(new Player(1));

        Player player = playerDaoService.findById(1l);
        assertNotNull(player);
        assertEquals(player.getId(), 1);
    }

}