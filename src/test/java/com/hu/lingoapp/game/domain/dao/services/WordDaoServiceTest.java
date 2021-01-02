package com.hu.lingoapp.game.domain.dao.services;

import com.hu.lingoapp.game.data.dtos.PlayerDto;
import com.hu.lingoapp.game.data.dtos.WordDto;
import com.hu.lingoapp.game.data.services.WordData;
import com.hu.lingoapp.game.domain.dao.converters.WordConverter;
import com.hu.lingoapp.game.domain.models.Player;
import com.hu.lingoapp.game.domain.models.Word;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

class WordDaoServiceTest {

    @Mock
    private WordData data;

    @Mock
    private WordConverter converter;

    @InjectMocks
    @Resource
    private WordDaoService wordDaoService;

    @BeforeEach
    void setUp() {
        wordDaoService = new WordDaoService();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void save_word_to_db() {
        when(converter.convertModelToEntity(new Word("word"))).thenReturn(new WordDto("word"));
        when(data.save(new WordDto("word"))).thenReturn(new WordDto("word"));
        when(converter.convertEntityToModel(new WordDto("word"))).thenReturn(new Word("word"));

        Word word = wordDaoService.save(new Word("word"));
        assertNotNull(word);
        assertEquals(word.getText(), "word");
    }

    @Test
    void count_words_in_db() {
        when(data.count()).thenReturn(1000l);
        assertEquals(wordDaoService.count(), 1000l);
    }

    @Test
    void count_valid_words_in_db() {
        when(data.countValidWords()).thenReturn(1000l);
        assertEquals(wordDaoService.countValidWords(), 1000l);
    }

    @Test
    void find_word_by_id() {
        when(data.findById(1l)).thenReturn(Optional.of(new WordDto("word")));
        when(converter.convertEntityToModel(new WordDto("word"))).thenReturn(new Word("word"));

        Word word = wordDaoService.findById(1l);
        assertNotNull(word);
        assertEquals(word.getText(), "word");
    }

    @Test
    void get_valid_words_from_db() {
        when(data.getValidWords()).thenReturn(new ArrayList<>());
        when(converter.convertEntitiesToModels(new ArrayList<>())).thenReturn(new ArrayList<>());
        List<Word> words = wordDaoService.getValidWords();
        assertNotNull(words);
    }

}