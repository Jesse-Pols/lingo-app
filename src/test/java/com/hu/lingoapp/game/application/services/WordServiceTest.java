package com.hu.lingoapp.game.application.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class WordServiceTest {
    private WordService service;

    @BeforeEach
    void beforeEach() {
        service = new WordService();
    }

    @ParameterizedTest
    @MethodSource("provideFileNamesWithDifferentPaths")
    void readFromTxtFile(String fileName, List<String> shouldResult) throws FileNotFoundException {
        List<String> result = service.readFromTxtFile(fileName);
        assertEquals(shouldResult.getClass(), result.getClass());
    }

    static Stream<Arguments> provideFileNamesWithDifferentPaths() {
        return Stream.of(
            Arguments.of("basiswoorden-gekeurd", new ArrayList<String>())
        );
    }
}