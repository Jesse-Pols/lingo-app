package com.hu.lingoapp.game.application.services;

import com.hu.lingoapp.game.domain.dao.WordDao;
import com.hu.lingoapp.game.domain.models.Word;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class WordServiceTest {

    @Mock
    private WordDao dao;

    @InjectMocks
    @Resource
    private WordService service;

    @BeforeEach
    void beforeEach() {
        service = new WordService();

        //TODO find other solution
        MockitoAnnotations.initMocks(this);

        when(dao.count()).thenReturn(1000l);
    }

    @Test
    void chooseRandomWord() {
        Word word;

        word = service.chooseRandomWord();

        assertNotNull(word);
    }
}