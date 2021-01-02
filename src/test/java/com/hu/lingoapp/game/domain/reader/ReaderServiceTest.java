package com.hu.lingoapp.game.domain.reader;

import com.hu.lingoapp.game.data.reader.TxtReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.annotation.Resource;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

class ReaderServiceTest {

    @Mock
    private TxtReader txtReader;

    @InjectMocks
    @Resource
    private ReaderService readerService;

    @BeforeEach
    void setUp() {
        readerService = new ReaderService();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void read_words_from_txt_file() throws FileNotFoundException {
        when(txtReader.read("basiswoorden-gekeurd", true)).thenReturn(new ArrayList<>());
        List<String> list = readerService.readWordsFromTxtFile("basiswoorden-gekeurd", true);
        assertNotNull(list);
    }

}