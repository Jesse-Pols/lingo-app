package com.hu.lingoapp.game.data.services.implementations;

import com.hu.lingoapp.game.data.dtos.PlayerDto;
import com.hu.lingoapp.game.data.dtos.WordDto;
import com.hu.lingoapp.game.data.repositories.WordRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class WordDataServiceTest {

    @Mock
    private WordRepository wordRepository;

    @InjectMocks
    @Resource
    private WordDataService wordDataService;

    @BeforeEach
    void setUp() {
        wordDataService = new WordDataService();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void save_word_dto() {
        when(wordRepository.save(any())).thenReturn(new WordDto("word"));
        WordDto word = wordDataService.save(new WordDto());

        assertNotNull(word);
        assertTrue((word.getText().equals("word")));
    }

    @Test
    void count_words_in_db() {
        when(wordRepository.count()).thenReturn(12l);
        long count = wordDataService.count();
        assertTrue(count > 0);
    }

    @Test
    void find_word_by_id() {
        when(wordRepository.findById(1l)).thenReturn(Optional.of(new WordDto("word")));
        Optional<WordDto> wordDto = wordDataService.findById(1);
        assertNotNull(wordDto);
        assertEquals(wordDto.get().getText(), "word");
    }

    @Test
    void count_valid_words_in_db() {
        when(wordRepository.countValidWords()).thenReturn(12l);
        long count = wordDataService.countValidWords();
        assertTrue(count > 0);
    }

    @Test
    void get_valid_words_from_db() {
        when(wordRepository.getValidWords()).thenReturn(new ArrayList<>());
        List<WordDto> list = wordDataService.getValidWords();
        assertNotNull(list);
    }
}