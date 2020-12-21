package com.hu.lingoapp.game.presentation.controllers;

import com.hu.lingoapp.game.application.services.GuessService;
import com.hu.lingoapp.game.domain.models.Letter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;

class GuessControllerTest {

    @Mock
    private GuessService guessService;

    @InjectMocks
    @Resource
    private GuessController guessController;

    @BeforeEach
    void beforeEach() {
        this.guessController = new GuessController();
        //TODO find other solution
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void guess_succesfully() throws Exception {
        when(guessService.guess("word")).thenReturn(new ArrayList<>());
        var response = guessController.guess("word");
        assertEquals(response.getStatusCode(), OK);
    }

    @Test
    void guess_failing() throws Exception {
        when(guessService.guess("word")).thenReturn(null);
        var response = guessController.guess("word");
        assertEquals(response.getStatusCode(), BAD_REQUEST);
    }

}