package com.hu.lingoapp.game.data.services.implementations;

import com.hu.lingoapp.game.data.dtos.GameDto;
import com.hu.lingoapp.game.data.dtos.PlayerDto;
import com.hu.lingoapp.game.data.repositories.PlayerRepository;
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

class PlayerDataServiceTest {

    @Mock
    private PlayerRepository playerRepository;

    @InjectMocks
    @Resource
    private PlayerDataService playerDataService;

    @BeforeEach
    void setUp() {
        playerDataService = new PlayerDataService();
        //TODO find other solution
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void save_player_dto() {
        when(playerRepository.save(any())).thenReturn(new PlayerDto(1));
        PlayerDto playerDto = playerDataService.save(new PlayerDto());

        assertNotNull(playerDto);
        assertTrue((playerDto.getId() == 1));
    }

    @Test
    void find_all_players() {
        when(playerRepository.findAll()).thenReturn(new ArrayList<>());
        List<PlayerDto> list = playerDataService.findAll();
        assertNotNull(list);
    }

    @Test
    void find_player_by_id() {
        when(playerRepository.findById(1l)).thenReturn(Optional.of(new PlayerDto(1)));
        Optional<PlayerDto> playerDto = playerDataService.findById(1);
        assertNotNull(playerDto);
        assertTrue(playerDto.get().getId() == 1);
    }
}