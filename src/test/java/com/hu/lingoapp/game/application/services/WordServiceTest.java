package com.hu.lingoapp.game.application.services;

import com.hu.lingoapp.game.domain.dao.WordDao;
import com.hu.lingoapp.game.domain.models.Word;
import com.hu.lingoapp.game.domain.reader.Reader;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

class WordServiceTest {

    @Mock
    private WordDao dao;

    @Mock
    private Reader reader;

    @Mock
    private VerificationService verificationService;

    @InjectMocks
    @Resource
    private WordService wordService;

    @BeforeEach
    void beforeEach() {
        wordService = new WordService();

        //TODO find other solution
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void choose_a_random_word_from_db_with_id_below_1000() {
        List<Word> words1 = new ArrayList<>();
        words1.add(new Word("woord"));
        words1.add(new Word("pizza"));
        words1.add(new Word("broer"));
        words1.add(new Word("vriend"));
        words1.add(new Word(""));

        when(dao.getValidWordsOf5Letters()).thenReturn(words1);
        Word word = wordService.chooseRandomWord(5);
        assertNotNull(word);
    }

    @ParameterizedTest
    @MethodSource("provideListsWithDifferentValues")
    void read_words_from_txt_file(List<String> list) {
        when(reader.readWordsFromTxtFile("filename", false)).thenReturn(list);
        List<String> words = wordService.readFromTxtFile("filename", false);
        assertEquals(words,list);
    }

    @Test
    void save_words_to_db() {
        when(dao.save(new Word(anyString()))).thenReturn(new Word("woord"));
        boolean accepts = wordService.save(new Word("woord"));
        assertTrue(accepts);
    }

    @Test
    void save_words_from_txt_file() {
        when(dao.save(new Word(anyString()))).thenReturn(new Word("woord"));
        boolean accepts = wordService.saveFromTxtFile("filepath", false);
        assertTrue(accepts);
    }

    @ParameterizedTest
    @MethodSource("provideListsWithDifferentValues")
    void save_list_of_strings_to_db(List<String> list, boolean shouldAccept) {
        when(dao.save(new Word(anyString()))).thenReturn(new Word("woord"));
        boolean accepts = wordService.saveStringList(list, "bundleName");
        assertEquals(accepts, shouldAccept);
    }

    @Test
    void delete_invalid_words_from_wordlist() {
        when(verificationService.verifyRegex(any())).thenReturn(true);
        assertTrue(wordService.deleteInvalidWords("file"));
    }

    static Stream<Arguments> provideListsWithDifferentValues() {

        List<String> list1 = new ArrayList<>();
        list1.add("woord");
        list1.add("pizza");
        list1.add("broer");
        list1.add("vriend");
        list1.add("");

        List<String> list2 = new ArrayList<>();
        list2.add("woord");
        list2.add(null);
        list1.add("vriend");

        return Stream.of(
                Arguments.of(list1, true),
                Arguments.of(list2, false)
        );
    }

}