package com.hu.lingoapp.game.domain.reader;

import com.hu.lingoapp.game.data.reader.TxtReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReaderService implements Reader {
    @Autowired
    private TxtReader txtReader;

    @Override
    public List<String> readWordsFromTxtFile(String fileName, boolean minimized) {
        try {
            return txtReader.read(fileName, minimized);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
