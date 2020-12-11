package com.hu.lingoapp.game.data.services;

import com.hu.lingoapp.game.data.dtos.WordDto;

import java.util.List;
import java.util.Optional;

public interface WordData {
    WordDto save(WordDto word);
    long count();
    Optional<WordDto> findById(long id);
    long countValidWords();
    List<WordDto> getValidWords();
}
