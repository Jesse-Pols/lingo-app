package com.hu.lingoapp.game.data.dao;

import com.hu.lingoapp.game.data.entities.GameEntity;
import com.hu.lingoapp.game.data.repositories.GameRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameDaoServiceTest {

    private GameRepository gameRepository = Mockito.mock(GameRepository.class);

    @Test
    void findAll() {
        List<GameEntity> games = (List<GameEntity>) gameRepository.findAll();
        assertThat(!games.isEmpty());
    }
}