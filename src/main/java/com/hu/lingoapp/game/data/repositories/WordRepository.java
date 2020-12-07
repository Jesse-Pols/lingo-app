package com.hu.lingoapp.game.data.repositories;

import com.hu.lingoapp.game.data.dtos.WordDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepository extends CrudRepository<WordDto, Long> {
}
