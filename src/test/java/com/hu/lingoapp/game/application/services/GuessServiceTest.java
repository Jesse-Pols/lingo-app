package com.hu.lingoapp.game.application.services;

import com.hu.lingoapp.game.domain.models.Letter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GuessServiceTest {

    @Mock
    private GameService gameService;

    @Mock
    private VerificationService verificationService;

    @InjectMocks
    @Resource
    private GuessService service;

    @BeforeEach
    void beforeEach() {
        service = new GuessService();
    }

    @ParameterizedTest
    @MethodSource("provideVariousWordsAndAnswers")
    void single_guess_where_word_should_be_checked(String word, String answer, List<Letter> shouldAccept) {
        //TODO find other solution
        MockitoAnnotations.initMocks(this);
        when(gameService.getCurrentGameAnswer()).thenReturn(answer);
        when(verificationService.verifyGuess(word, LocalDateTime.now())).thenReturn(true);

        List<Letter> accepts = null;
        try {
            accepts = service.guess(word);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(shouldAccept, accepts);
    }

    @ParameterizedTest
    @MethodSource("provideVariousWordsAndAnswers")
    void check_all_letters_in_string(String word, String answer, List<Letter> shouldAccept) {
        List<Letter> accepts = service.checkLetters(word, answer);
        assertEquals(shouldAccept, accepts);
    }


    @ParameterizedTest
    @MethodSource("provideVariousWordsAnswersAndLetters")
    void checks_if_letter_is_correct_or_present_or_neither(String word, String answer, int i, Letter shouldAccept) {
        Letter accepts = service.checkLetter(word, answer, i);
        assertEquals(shouldAccept, accepts);
    }

    static Stream<Arguments> provideVariousWordsAndAnswers() {


        List<Letter> list1 = new ArrayList<>();
        list1.add(new Letter(0, "p", true, true));
        list1.add(new Letter(1, "i", true, true));
        list1.add(new Letter(2, "z", true, true));
        list1.add(new Letter(3, "z", true, true));
        list1.add(new Letter(4, "a", true, true));

        List<Letter> list2 = new ArrayList<>();
        list2.add(new Letter(0, "j", false, false));
        list2.add(new Letter(1, "a", false, false));

        List<Letter> list3 = new ArrayList<>();
        list3.add(new Letter(0, "b", false, false));
        list3.add(new Letter(1, "a", false, false));
        list3.add(new Letter(2, "c", false, false));
        list3.add(new Letter(3, "k", false, false));
        list3.add(new Letter(4, "e", false, true));
        list3.add(new Letter(5, "n", false, true));
        list3.add(new Letter(6, "d", false, true));

        List<Letter> list4 = new ArrayList<>();
        list4.add(new Letter(0, "j", false, false));
        list4.add(new Letter(1, "a", true, true));
        list4.add(new Letter(2, "c", false, false));
        list4.add(new Letter(3, "h", false, false));
        list4.add(new Letter(4, "t", false, true));

        return Stream.of(
                Arguments.of("pizza", "pizza", list1),
                Arguments.of("ja", "nee", list2),
                Arguments.of("backend", "frontend", list3),
                Arguments.of("jacht", "taboe", list4)
        );
    }

    static Stream<Arguments> provideVariousWordsAnswersAndLetters() {
        return Stream.of(
                Arguments.of("pizza", "pizza", 2, new Letter(2, "z", true, true)),
                Arguments.of("pizzas", "soepel", 5, new Letter(5, "s", false, true)),
                Arguments.of("backend", "frontend", 3, new Letter(3, "k", false, false)),
                Arguments.of(null, null, 9999, null),
                Arguments.of("software", "software", -1, null),
                Arguments.of("shrubbery", "anothershrubbery", 9, new Letter(9, null, false, false)),
                Arguments.of("anothershrubbery", "shrubbery", 9, new Letter(9, "r", false, true))

        );
    }
}