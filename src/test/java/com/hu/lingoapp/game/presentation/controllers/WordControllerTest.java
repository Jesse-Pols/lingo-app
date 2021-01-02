package com.hu.lingoapp.game.presentation.controllers;

import com.hu.lingoapp.game.application.services.WordService;
import com.hu.lingoapp.game.domain.models.Word;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class WordControllerTest {

    @Mock
    private WordService wordService;

    @InjectMocks
    @Resource
    private WordController wordController;

    @BeforeEach
    void beforeEach() {
        this.wordController = new WordController();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void save() {
        when(wordService.save(new Word("word"))).thenReturn(true);
        assertTrue(wordController.save("word"));
    }

    @Test
    void save_file_to_db() {
        when(wordService.saveFromTxtFile("path", true)).thenReturn(true);
        assertTrue(wordController.saveFile("path", true));
    }

    @Test
    void get_random_word() {
        when(wordService.chooseRandomWord(5)).thenReturn(new Word("word"));
        Word word = wordController.getRandomWords();
        assertEquals(word, new Word("word"));
    }

    @Test
    void delete_invalid_words() {
        when(wordService.deleteInvalidWords("path")).thenReturn(true);
        assertTrue(wordController.deleteInvalidWords("path"));
    }

}