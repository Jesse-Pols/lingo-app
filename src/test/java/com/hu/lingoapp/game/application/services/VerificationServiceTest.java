package com.hu.lingoapp.game.application.services;

import com.hu.lingoapp.game.domain.models.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class VerificationServiceTest {
    private VerificationService service;

    @BeforeEach
    void beforeEach() {
        service = new VerificationService();
    }

    @ParameterizedTest
    @MethodSource("provideWordsAndDates")
    void run_verifications_with_different_data(String word, LocalDateTime dateTime, boolean shouldAccept) {
        boolean accepts = service.verifyGuess(word, dateTime);
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

    @ParameterizedTest
    @MethodSource("provideDifferentDatesAndTimes")
    void accepts_different_kinds_of_times(LocalDateTime dateTime, boolean shouldAccept) {
        boolean accepts = service.verifyTimer(dateTime);
        assertEquals(shouldAccept, accepts);
    }

    static Stream<Arguments> provideWordsAndDates() {
        return Stream.of(
                Arguments.of("Pizza", LocalDateTime.now(), false),
                Arguments.of("beer", LocalDateTime.now().minusSeconds(20), false),
                Arguments.of("software", LocalDateTime.now().plusSeconds(20), false),
                Arguments.of("woord", LocalDateTime.now().plusSeconds(20), true),
                Arguments.of("developer", LocalDateTime.now().minusSeconds(9), false),
                Arguments.of("gezin", LocalDateTime.now().minusSeconds(9), true),
                Arguments.of("bruv", null, false),
                Arguments.of("broer", null, false),
                Arguments.of(null, null, false),
                Arguments.of(null, LocalDateTime.now(), false)
        );
    }

    static Stream<Arguments> provideDifferentDatesAndTimes() {
        return Stream.of(
                Arguments.of(LocalDateTime.now(), true),
                Arguments.of(LocalDateTime.now().minusSeconds(20), false),
                Arguments.of(LocalDateTime.now().plusSeconds(120), true),
                Arguments.of(LocalDateTime.now().minusSeconds(9), true)
        );
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