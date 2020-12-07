package com.hu.lingoapp.game.application.services;

import com.hu.lingoapp.game.domain.models.Word;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class WordService {

    private String basePath = "wordlists/";

    public List<String> readFromTxtFile(String fileName) throws FileNotFoundException {
        // TODO: Decide wether or not to move this to another layer (Data layer?)
        List<String> words = new ArrayList<>();

        File file = ResourceUtils.getFile("classpath:" + basePath + fileName);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            words.add(scanner.next());
        }
        scanner.close();

        return words;
    }

    public boolean save(Word word) {
        return false;

    }

    // Save words from txt file to DB
    public boolean saveFromTxtFile() {
        return false;
    }

}
