package com.hu.lingoapp.game.domain.dao.converters;

import com.hu.lingoapp.game.data.dtos.GameDto;
import com.hu.lingoapp.game.data.dtos.PlayerDto;
import com.hu.lingoapp.game.domain.dao.services.PlayerDaoService;
import com.hu.lingoapp.game.domain.dao.services.WordDaoService;
import com.hu.lingoapp.game.domain.models.Game;
import com.hu.lingoapp.game.domain.models.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GameConverterTest {

    @Mock
    private PlayerDaoService playerDaoService;

    @Mock
    private WordDaoService wordDaoService;

    @InjectMocks
    @Resource
    private GameConverter gameConverter;

    @BeforeEach
    void beforeEach() {
        gameConverter = new GameConverter();
        MockitoAnnotations.initMocks(this);
    }

    @ParameterizedTest
    @MethodSource("provideGameEntitiesWithDifferentData")
    void convert_entity_to_model(GameDto entity, Game shouldResult) {
        when(playerDaoService.findById(entity.getPlayer_id())).thenReturn(shouldResult.getPlayer());
        when(wordDaoService.findById(entity.getAnswer_id())).thenReturn(shouldResult.getAnswer());

        Game game = gameConverter.convertEntityToModel(entity);
        assertEquals(game, shouldResult);
    }

    @ParameterizedTest
    @MethodSource("provideGameEntityListsWithDifferentData")
    void convert_entity_list_to_model_list(List<GameDto> entities, List<Game> shouldResult) {
        List<Game> list = gameConverter.convertEntitiesToModels(entities);
        assertEquals(list, shouldResult);
    }

    @ParameterizedTest
    @MethodSource("provideGamesWithDifferentData")
    void convert_model_to_entity(Game model, GameDto shouldResult) {
        GameDto result = gameConverter.convertModelToEntity(model);
        assertEquals(result, shouldResult);
    }

    @ParameterizedTest
    @MethodSource("provideGameListsWithDifferentData")
    void convert_model_list_to_entity_list(List<Game> models, List<GameDto> shouldResult) {
        List<GameDto> result = gameConverter.convertModelsToEntities(models);
        assertEquals(result, shouldResult);
    }

    static Stream<Arguments> provideGameEntitiesWithDifferentData() {
        return Stream.of(
                Arguments.of(new GameDto(1l), new Game(1l)),
                Arguments.of(new GameDto(0l, 0l), new Game(0l, new Player(0l, "Henk", 0))),
                Arguments.of(new GameDto(99999999999999l), new Game(99999999999999l)),
                Arguments.of(new GameDto(-1l), new Game(-1l)),
                Arguments.of(new GameDto(), new Game())
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
                Arguments.of(new Game(), new GameDto())

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