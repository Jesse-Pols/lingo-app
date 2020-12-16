package com.hu.lingoapp.game.data.reader;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class ReadFromTxtFile implements TxtReader {

    @Override
    public List<String> read(String fileName, boolean minimized) throws FileNotFoundException {
        List<String> words = new ArrayList<>();
        String basePath = "wordlist/";
        if (minimized) basePath += "minimized-words/";

        File file = new File(basePath + fileName);
        Scanner scanner = new Scanner(file);
        while(scanner.hasNext()) {
            words.add(scanner.next());
        }
        scanner.close();

        return words;
    }
}
