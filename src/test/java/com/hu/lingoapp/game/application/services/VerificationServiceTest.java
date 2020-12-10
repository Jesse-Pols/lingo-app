package com.hu.lingoapp.game.application.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class VerificationServiceTest {
    private VerificationService service;

    @BeforeEach
    void beforeEach() {
        service = new VerificationService();
    }

    @ParameterizedTest
    @MethodSource("provideWordsOfVaryingLength")
    void runs_every_verification_succesfully_with_5_6_7_letters_only(String word, boolean shouldAccept) {
        boolean accepts = service.verify(word);
        assertEquals(shouldAccept, accepts);
    }

    @ParameterizedTest
    @MethodSource("provideWordsOfVaryingCaseSymbols")
    void runs_every_verification_succesfully_with_lowercase_letters_only(String word, boolean shouldAccept) {
        boolean accepts = service.verify(word);
        assertEquals(shouldAccept, accepts);
    }

    @ParameterizedTest
    @MethodSource("provideWordsOfVaryingLength")
    void accepts_words_of_5_6_7_letters_only(String word, boolean shouldAccept) {
        boolean accepts = service.verifyRegex(word);
        assertEquals(shouldAccept, accepts);
    }

    @ParameterizedTest
    @MethodSource("provideWordsOfVaryingCaseSymbols")
    void accepts_words_of_lowercase_letters_only(String word, boolean shouldAccept) {
        boolean accepts = service.verifyRegex(word);
        assertEquals(shouldAccept, accepts);
    }

    static Stream<Arguments> provideWordsOfVaryingLength() {
        return Stream.of(
                Arguments.of("pizza", true),
                Arguments.of("pizzas", true),
                Arguments.of("backend", true),
                Arguments.of("beer", false),
                Arguments.of("software", false),
                Arguments.of("developer", false)
        );
    }

    static Stream<Arguments> provideWordsOfVaryingCaseSymbols() {
        return Stream.of(
                Arguments.of("pizza", true),
                Arguments.of("Pizza", false),
                Arguments.of("PiZZa", false),
                Arguments.of("PIZZA", false),
                Arguments.of("pizzA", false),
                Arguments.of("piZza", false),
                Arguments.of("piZzä", false),
                Arguments.of("p!zza", false),
                Arguments.of("P!ZZA", false),
                Arguments.of("piZ a", false),
                Arguments.of("p̣̝̔̂͝i̻͚ͅz̰̟̖̩̩̘z̖̭̞͉͍̕a͖͛̓͘", false)
        );
    }
}