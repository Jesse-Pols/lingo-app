package com.hu.lingoapp.game.data.repositories;

import com.hu.lingoapp.game.data.entities.PlayerEntity;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<PlayerEntity, Long> {
}
