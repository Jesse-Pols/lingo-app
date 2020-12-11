package com.hu.lingoapp.game.data.repositories;

import com.hu.lingoapp.game.data.dtos.WordDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WordRepository extends CrudRepository<WordDto, Long> {
    long countValidWords();
    List<WordDto> getValidWords();
}
