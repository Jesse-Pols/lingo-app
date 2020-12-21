package com.hu.lingoapp.game.domain.dao.converters;

import com.hu.lingoapp.game.data.dtos.GameDto;
import com.hu.lingoapp.game.data.dtos.PlayerDto;
import com.hu.lingoapp.game.data.dtos.WordDto;
import com.hu.lingoapp.game.domain.models.Game;
import com.hu.lingoapp.game.domain.models.Player;
import com.hu.lingoapp.game.domain.models.Word;
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
                Arguments.of(new PlayerDto(), new Player()),
                Arguments.of(new PlayerDto(1, "Henk", 0), new Player(1, "Henk", 0)),
                Arguments.of(null, null),
                Arguments.of(new PlayerDto(0, "", 0), new Player(0, "", 0))
        );
    }

    static Stream<Arguments> providePlayerEntityListsWithDifferentData() {
        List<PlayerDto> list1 = new ArrayList<>();
        list1.add(new PlayerDto(1, "Henk", 0));
        list1.add(null);
        List<Player> list2 = new ArrayList<>();
        list2.add(new Player(1, "Henk", 0));
        list2.add(null);

        return Stream.of(
                Arguments.of(new ArrayList<>(), new ArrayList<>()),
                Arguments.of(list1, list2),
                Arguments.of(null, null)
        );
    }

    static Stream<Arguments> providePlayersWithDifferentData() {
        return Stream.of(
                Arguments.of(new Player(), new PlayerDto()),
                Arguments.of(new Player(1, "Henk", 0), new PlayerDto(1, "Henk", 0)),
                Arguments.of(null, null),
                Arguments.of(new Player(0, "", 0), new PlayerDto(0, "", 0))
        );
    }

    static Stream<Arguments> providePlayerListsWithDifferentData() {
        List<Player> list1 = new ArrayList<>();
        list1.add(new Player(1, "Henk", 0));
        list1.add(null);
        List<PlayerDto> list2 = new ArrayList<>();
        list2.add(new PlayerDto(1, "Henk", 0));
        list2.add(null);

        return Stream.of(
                Arguments.of(new ArrayList<>(), new ArrayList<>()),
                Arguments.of(list1, list2),
                Arguments.of(null, null)
        );
    }
}