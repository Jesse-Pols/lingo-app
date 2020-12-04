package com.hu.lingoapp.game.data.services;

import com.hu.lingoapp.game.data.dtos.PlayerDto;

import java.util.List;
import java.util.Optional;

public interface PlayerData {
    List<PlayerDto> findAll();
    Optional<PlayerDto> findById(Long id);
}
