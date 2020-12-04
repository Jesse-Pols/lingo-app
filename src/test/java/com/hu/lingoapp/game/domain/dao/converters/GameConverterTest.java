package com.hu.lingoapp.game.domain.dao.converters;

import com.hu.lingoapp.game.data.entities.GameEntity;
import com.hu.lingoapp.game.domain.domainobjects.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
    void convertEntityToModel(GameEntity entity, Game shouldResult) {
        Game result = converter.convertEntityToModel(entity);
        assertEquals(shouldResult, result);
    }

    @ParameterizedTest
    @MethodSource("provideGameEntityListsWithDifferentData")
    void convertEntitiesToModels(List<GameEntity> entities, List<Game> shouldResult) {
        List<Game> result = converter.convertEntitiesToModels(entities);
        assertEquals(shouldResult, result);
    }

    @ParameterizedTest
    @MethodSource("provideGamesWithDifferentData")
    void convertModelToEntity(Game model, GameEntity shouldResult) {
        GameEntity result = converter.convertModelToEntity(model);
        assertEquals(result, shouldResult);
    }

    @ParameterizedTest
    @MethodSource("provideGameListsWithDifferentData")
    void convertModelsToEntities(List<Game> models, List<GameEntity> shouldResult) {
        List<GameEntity> result = converter.convertModelsToEntities(models);
        assertEquals(result, shouldResult);
    }

    static Stream<Arguments> provideGameEntitiesWithDifferentData() {
        return Stream.of(
                Arguments.of(new GameEntity(1l), new Game(1l)),
                Arguments.of(new GameEntity(0l), new Game(0l)),
                Arguments.of(new GameEntity(99999999999999l), new Game(99999999999999l)),
                Arguments.of(new GameEntity(-1l), new Game(-1l)),
                Arguments.of(new GameEntity(), new Game()),
                Arguments.of(new GameEntity(null), new Game())
        );
    }

    static Stream<Arguments> provideGameEntityListsWithDifferentData() {
        List<GameEntity> list1 = new ArrayList<>();
        list1.add(new GameEntity(1l));
        list1.add(new GameEntity(999999l));
        list1.add(new GameEntity(0l));
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
                Arguments.of(new Game(1l), new GameEntity(1l)),
                Arguments.of(new Game(0l), new GameEntity(0l)),
                Arguments.of(new Game(99999999999999l), new GameEntity(99999999999999l)),
                Arguments.of(new Game(-1l), new GameEntity(-1l)),
                Arguments.of(new Game(), new GameEntity()),
                Arguments.of(new Game(null), new GameEntity())

        );
    }

    static Stream<Arguments> provideGameListsWithDifferentData() {
        List<Game> list1 = new ArrayList<>();
        list1.add(new Game(1l));
        list1.add(new Game(999999l));
        list1.add(new Game(0l));
        List<GameEntity> list2 = new ArrayList<>();
        list2.add(new GameEntity(1l));
        list2.add(new GameEntity(999999l));
        list2.add(new GameEntity(0l));

        return Stream.of(
                Arguments.of(new ArrayList<>(), new ArrayList<>()),
                Arguments.of(list1, list2)
        );
    }
}