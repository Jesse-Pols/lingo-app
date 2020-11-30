package com.hu.lingoapp.data.repositories;

import com.hu.lingoapp.data.entities.GameEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends CrudRepository<GameEntity, Long> {

    @Query("FROM GameEntity WHERE id = 1")
    List<GameEntity> findFirstGame();

}
