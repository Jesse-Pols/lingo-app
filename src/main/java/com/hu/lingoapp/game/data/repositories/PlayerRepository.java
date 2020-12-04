package com.hu.lingoapp.game.data.repositories;

import com.hu.lingoapp.game.data.dtos.PlayerDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends CrudRepository<PlayerDto, Long> {
}
