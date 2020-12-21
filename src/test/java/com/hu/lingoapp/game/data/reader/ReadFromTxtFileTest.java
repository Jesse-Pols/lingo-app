package com.hu.lingoapp.game.data.reader;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReadFromTxtFileTest {

    private ReadFromTxtFile readFromTxtFile;

    @BeforeEach
    void beforeEach() {
        readFromTxtFile = new ReadFromTxtFile();
    }

    @Test
    void read_from_txt_file() throws FileNotFoundException {
        List<String> list = readFromTxtFile.read("basiswoorden-gekeurd", false);
        assertNotNull(list);
        assertFalse(list.isEmpty());
    }

}