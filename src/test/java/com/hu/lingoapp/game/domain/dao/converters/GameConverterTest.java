package com.hu.lingoapp.game.domain.dao.converters;

import com.hu.lingoapp.game.data.dtos.GameDto;
import com.hu.lingoapp.game.domain.models.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GameConverterTest {
    private GameConverter converter;

    @BeforeEach
    void beforeEach() {
        converter = new GameConverter();
    }

    @ParameterizedTest
    @MethodSource("provideGameEntitiesWithDifferentData")
    void convertEntityToModel(GameDto entity, Game shouldResult) {
        Game result = converter.convertEntityToModel(entity);
        assertEquals(shouldResult, result);
    }

    @ParameterizedTest
    @MethodSource("provideGameEntityListsWithDifferentData")
    void convertEntitiesToModels(List<GameDto> entities, List<Game> shouldResult) {
        List<Game> result = converter.convertEntitiesToModels(entities);
        assertEquals(shouldResult, result);
    }

    @ParameterizedTest
    @MethodSource("provideGamesWithDifferentData")
    void convertModelToEntity(Game model, GameDto shouldResult) {
        GameDto result = converter.convertModelToEntity(model);
        assertEquals(result, shouldResult);
    }

    @ParameterizedTest
    @MethodSource("provideGameListsWithDifferentData")
    void convertModelsToEntities(List<Game> models, List<GameDto> shouldResult) {
        List<GameDto> result = converter.convertModelsToEntities(models);
        assertEquals(result, shouldResult);
    }

    static Stream<Arguments> provideGameEntitiesWithDifferentData() {



        return Stream.of(
                Arguments.of(new GameDto(1l), new Game(1l)),
                Arguments.of(new GameDto(0l), new Game(0l)),
                Arguments.of(new GameDto(99999999999999l), new Game(99999999999999l)),
                Arguments.of(new GameDto(-1l), new Game(-1l)),
                Arguments.of(new GameDto(), new Game()),
                Arguments.of(new GameDto(null), new Game())
        );
    }

    static Stream<Arguments> provideGameEntityListsWithDifferentData() {
        List<GameDto> list1 = new ArrayList<>();
        list1.add(new GameDto(1l));
        list1.add(new GameDto(999999l));
        list1.add(new GameDto(0l));
        List<Game> list2 = new ArrayList<>();
        list2.add(new Game(1l));
        list2.add(new Game(999999l));
        list2.add(new Game(0l));

        return Stream.of(
                Arguments.of(new ArrayList<>(), new ArrayList<>()),
                Arguments.of(list1, list2)
        );
    }

    static Stream<Arguments> provideGamesWithDifferentData() {
        return Stream.of(
                Arguments.of(new Game(1l), new GameDto(1l)),
                Arguments.of(new Game(0l), new GameDto(0l)),
                Arguments.of(new Game(99999999999999l), new GameDto(99999999999999l)),
                Arguments.of(new Game(-1l), new GameDto(-1l)),
                Arguments.of(new Game(), new GameDto()),
                Arguments.of(new Game(null), new GameDto())

        );
    }

    static Stream<Arguments> provideGameListsWithDifferentData() {
        List<Game> list1 = new ArrayList<>();
        list1.add(new Game(1l));
        list1.add(new Game(999999l));
        list1.add(new Game(0l));
        List<GameDto> list2 = new ArrayList<>();
        list2.add(new GameDto(1l));
        list2.add(new GameDto(999999l));
        list2.add(new GameDto(0l));

        return Stream.of(
                Arguments.of(new ArrayList<>(), new ArrayList<>()),
                Arguments.of(list1, list2)
        );
    }
}