package com.hu.lingoapp.game.domain.dao;

import com.hu.lingoapp.game.domain.models.Word;

import java.util.List;

public interface WordDao {
    Word save(Word word);
    long count();
    long countValidWords();
    Word findById(Long id);
    List<Word> getValidWords();
}
