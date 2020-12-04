package com.hu.lingoapp.game.data.services.implementations;

import com.hu.lingoapp.game.data.services.PlayerData;
import com.hu.lingoapp.game.data.dtos.PlayerDto;
import com.hu.lingoapp.game.data.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerDataService implements PlayerData {
    @Autowired
    private PlayerRepository repository;

    @Override
    public List<PlayerDto> findAll() {
        return (List<PlayerDto>) repository.findAll();
    }

    @Override
    public Optional<PlayerDto> findById(Long id) {
        return repository.findById(id);
    }
}
