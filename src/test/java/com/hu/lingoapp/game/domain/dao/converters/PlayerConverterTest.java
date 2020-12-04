package com.hu.lingoapp.game.domain.dao.converters;

import com.hu.lingoapp.game.data.entities.GameEntity;
import com.hu.lingoapp.game.data.entities.PlayerEntity;
import com.hu.lingoapp.game.domain.domainobjects.Game;
import com.hu.lingoapp.game.domain.domainobjects.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PlayerConverterTest {
    private PlayerConverter converter;

    @BeforeEach
    void beforeEach() {
        converter = new PlayerConverter();
    }

    @ParameterizedTest
    @MethodSource("providePlayerEntitiesWithDifferentData")
    void convertEntityToModel(PlayerEntity entity, Player shouldResult) {
        Player result = converter.convertEntityToModel(entity);
        assertEquals(shouldResult, result);
    }

    @ParameterizedTest
    @MethodSource("providePlayerEntityListsWithDifferentData")
    void convertEntitiesToModels(List<PlayerEntity> entities, List<Player> shouldResult) {
        List<Player> result = converter.convertEntitiesToModels(entities);
        assertEquals(shouldResult, result);
    }

    @ParameterizedTest
    @MethodSource("providePlayersWithDifferentData")
    void convertModelToEntity(Player model, PlayerEntity shouldResult) {
        PlayerEntity result = converter.convertModelToEntity(model);
        assertEquals(result, shouldResult);
    }

    @ParameterizedTest
    @MethodSource("providePlayerListsWithDifferentData")
    void convertModelsToEntities(List<Player> models, List<PlayerEntity> shouldResult) {
        List<PlayerEntity> result = converter.convertModelsToEntities(models);
        assertEquals(result, shouldResult);
    }

    static Stream<Arguments> providePlayerEntitiesWithDifferentData() {
        return Stream.of(
                Arguments.of(new PlayerEntity(), new Player())
        );
    }

    static Stream<Arguments> providePlayerEntityListsWithDifferentData() {
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

    static Stream<Arguments> providePlayersWithDifferentData() {
        return Stream.of(
                Arguments.of(new Game(1l), new GameEntity(1l)),
                Arguments.of(new Game(0l), new GameEntity(0l)),
                Arguments.of(new Game(99999999999999l), new GameEntity(99999999999999l)),
                Arguments.of(new Game(-1l), new GameEntity(-1l)),
                Arguments.of(new Game(), new GameEntity()),
                Arguments.of(new Game(null), new GameEntity())

        );
    }

    static Stream<Arguments> providePlayerListsWithDifferentData() {
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