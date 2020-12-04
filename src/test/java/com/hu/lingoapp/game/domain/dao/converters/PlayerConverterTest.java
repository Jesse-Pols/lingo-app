package com.hu.lingoapp.game.domain.dao.converters;

import com.hu.lingoapp.game.data.dtos.GameDto;
import com.hu.lingoapp.game.data.dtos.PlayerDto;
import com.hu.lingoapp.game.domain.models.Game;
import com.hu.lingoapp.game.domain.models.Player;
import org.junit.jupiter.api.BeforeEach;
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
    void convertEntityToModel(PlayerDto entity, Player shouldResult) {
        Player result = converter.convertEntityToModel(entity);
        assertEquals(shouldResult, result);
    }

    @ParameterizedTest
    @MethodSource("providePlayerEntityListsWithDifferentData")
    void convertEntitiesToModels(List<PlayerDto> entities, List<Player> shouldResult) {
        List<Player> result = converter.convertEntitiesToModels(entities);
        assertEquals(shouldResult, result);
    }

    @ParameterizedTest
    @MethodSource("providePlayersWithDifferentData")
    void convertModelToEntity(Player model, PlayerDto shouldResult) {
        PlayerDto result = converter.convertModelToEntity(model);
        assertEquals(result, shouldResult);
    }

    @ParameterizedTest
    @MethodSource("providePlayerListsWithDifferentData")
    void convertModelsToEntities(List<Player> models, List<PlayerDto> shouldResult) {
        List<PlayerDto> result = converter.convertModelsToEntities(models);
        assertEquals(result, shouldResult);
    }

    static Stream<Arguments> providePlayerEntitiesWithDifferentData() {
        return Stream.of(
                Arguments.of(new PlayerDto(), new Player())
        );
    }

    static Stream<Arguments> providePlayerEntityListsWithDifferentData() {
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

    static Stream<Arguments> providePlayersWithDifferentData() {
        return Stream.of(
                Arguments.of(new Game(1l), new GameDto(1l)),
                Arguments.of(new Game(0l), new GameDto(0l)),
                Arguments.of(new Game(99999999999999l), new GameDto(99999999999999l)),
                Arguments.of(new Game(-1l), new GameDto(-1l)),
                Arguments.of(new Game(), new GameDto()),
                Arguments.of(new Game(null), new GameDto())

        );
    }

    static Stream<Arguments> providePlayerListsWithDifferentData() {
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