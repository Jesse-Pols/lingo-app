package com.hu.lingoapp.game.domain.dao.converters;

import com.hu.lingoapp.game.data.dtos.GameDto;
import com.hu.lingoapp.game.data.dtos.PlayerDto;
import com.hu.lingoapp.game.data.dtos.WordDto;
import com.hu.lingoapp.game.domain.models.Game;
import com.hu.lingoapp.game.domain.models.Player;
import com.hu.lingoapp.game.domain.models.Word;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class WordConverterTest {

    private WordConverter wordConverter;

    @BeforeEach
    void beforeEach() {
        wordConverter = new WordConverter();
    }

    @ParameterizedTest
    @MethodSource("provideWordEntitiesWithDifferentData")
    void convertEntityToModel(WordDto entity, Word shouldResult) {
        Word result = wordConverter.convertEntityToModel(entity);
        assertEquals(shouldResult, result);
    }

    @ParameterizedTest
    @MethodSource("provideWordEntityListsWithDifferentData")
    void convertEntitiesToModels(List<WordDto> entities, List<Word> shouldResult) {
        List<Word> result = wordConverter.convertEntitiesToModels(entities);
        assertEquals(shouldResult, result);
    }

    @ParameterizedTest
    @MethodSource("provideWordsWithDifferentData")
    void convertModelToEntity(Word model, WordDto shouldResult) {
        WordDto result = wordConverter.convertModelToEntity(model);
        assertEquals(result, shouldResult);
    }

    @ParameterizedTest
    @MethodSource("provideWordListsWithDifferentData")
    void convertModelsToEntities(List<Word> models, List<WordDto> shouldResult) {
        List<WordDto> result = wordConverter.convertModelsToEntities(models);
        assertEquals(result, shouldResult);
    }

    static Stream<Arguments> provideWordEntitiesWithDifferentData() {
        return Stream.of(
                Arguments.of(new WordDto(), new Word()),
                Arguments.of(new WordDto("WORD"), new Word("WORD")),
                Arguments.of(new WordDto(""), new Word("")),
                Arguments.of(new WordDto("text", "bUnDlE"), new Word("text", "bUnDlE")),
                Arguments.of(null, null)

        );
    }
    static Stream<Arguments> provideWordEntityListsWithDifferentData() {
        List<WordDto> list1 = new ArrayList<>();
        list1.add(new WordDto("woord"));
        list1.add(new WordDto());
        list1.add(new WordDto(""));
        List<Word> list2 = new ArrayList<>();
        list2.add(new Word("woord"));
        list2.add(new Word());
        list2.add(new Word(""));

        return Stream.of(
            Arguments.of(new ArrayList<>(), new ArrayList<>()),
                Arguments.of(null, null),
                Arguments.of(list1, list2)
        );
    }
    static Stream<Arguments> provideWordsWithDifferentData() {
        return Stream.of(
                Arguments.of(new Word(), new WordDto()),
                Arguments.of(new Word("WORD"), new WordDto("WORD")),
                Arguments.of(new Word(""), new WordDto("")),
                Arguments.of(new Word("text", "bUnDlE"), new WordDto("text", "bUnDlE")),
                Arguments.of(null, null)
        );
    }
    static Stream<Arguments> provideWordListsWithDifferentData() {
        List<Word> list1 = new ArrayList<>();
        list1.add(new Word("woord"));
        list1.add(new Word());
        list1.add(new Word(""));
        List<WordDto> list2 = new ArrayList<>();
        list2.add(new WordDto("woord"));
        list2.add(new WordDto());
        list2.add(new WordDto(""));

        return Stream.of(
                Arguments.of(new ArrayList<>(), new ArrayList<>()),
                Arguments.of(null, null),
                Arguments.of(list1, list2)
        );
    }
}