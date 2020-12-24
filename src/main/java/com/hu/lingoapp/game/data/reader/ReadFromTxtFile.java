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

    // We get and save our wordlists to the src/wordlists folder, instead of the resources folder
    // This is because it's much easier to edit and save the lists this way
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
