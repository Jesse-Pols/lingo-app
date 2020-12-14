package com.hu.lingoapp.game.application.services;

import com.hu.lingoapp.game.domain.dao.PlayerDao;
import com.hu.lingoapp.game.domain.models.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class PlayerServiceTest {
    @Mock
    private PlayerDao dao;

    @InjectMocks
    @Resource
    private PlayerService service;

    @BeforeEach
    void beforeEach() {
        service = new PlayerService();
        //TODO find other solution
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAllPlayers() {
        when(dao.findAll()).thenReturn(new ArrayList<>());
        List<Player> accept = service.getAllPlayers();
        assertEquals(new ArrayList<>(), accept);
    }

    @Test
    void save() {
        when(dao.save(new Player())).thenReturn(new Player(1));
        Player accept = service.save(new Player());
        assertEquals(new Player(1), accept);
    }
}