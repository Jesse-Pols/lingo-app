package com.hu.lingoapp.game.data.repositories;

import com.hu.lingoapp.game.data.entities.GameEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends CrudRepository<GameEntity, Long> {
}
