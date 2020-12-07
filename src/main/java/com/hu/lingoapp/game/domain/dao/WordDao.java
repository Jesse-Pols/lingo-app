package com.hu.lingoapp.game.domain.dao;

import com.hu.lingoapp.game.domain.models.Word;

import java.util.Optional;

public interface WordDao {
    Word save(Word word);
    long count();
    Word findById(Long id);
}
