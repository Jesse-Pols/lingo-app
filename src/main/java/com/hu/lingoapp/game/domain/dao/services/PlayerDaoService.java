package com.hu.lingoapp.game.domain.dao.services;

import com.hu.lingoapp.game.data.dtos.PlayerDto;
import com.hu.lingoapp.game.data.services.PlayerData;
import com.hu.lingoapp.game.data.services.implementations.PlayerDataService;
import com.hu.lingoapp.game.domain.dao.PlayerDao;
import com.hu.lingoapp.game.domain.dao.converters.PlayerConverter;
import com.hu.lingoapp.game.domain.models.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerDaoService implements PlayerDao {

    @Autowired
    private PlayerData data;

    @Autowired
    private PlayerConverter converter;

    @Override
    public List<Player> findAll() {
        List<PlayerDto> playerDtos = data.findAll();
        return converter.convertEntitiesToModels(playerDtos);
    }

    @Override
    public Player findById(Long id) {
        Optional<PlayerDto> player = data.findById(id);
        return converter.convertEntityToModel(player.get());
    }
}
