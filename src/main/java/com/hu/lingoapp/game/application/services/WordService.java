package com.hu.lingoapp.game.application.services;

import com.hu.lingoapp.game.domain.dao.WordDao;
import com.hu.lingoapp.game.domain.models.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

@Service
public class WordService {

    @Autowired
    private WordDao dao;

    //TODO to applcation.config
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
        // We don't need the word id, instead we return True if the save was a success.
        try {
            dao.save(word);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean saveStringList(List<String> words) {
        for (String string : words) {
            boolean success = this.save(new Word(string));
            if (!success) {
                System.err.println("FAILED TO SAVE: " + string);
            }
        }
        return true;
    }

    // Save words from txt file to DB
    public boolean saveFromTxtFile(String fileName) {
        List<String> words;
        try {
            words = this.readFromTxtFile(fileName);
            return this.saveStringList(words);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Use the amount of words to choose a random wordId, then get that word from the db
    public Word chooseRandomWord() {
        long amountOfWords = dao.count();
        if (amountOfWords == 0) {
            System.out.println("No words were found. Try added words to the database.");
            return null;
        }

        long randomId = new Random().nextInt(Math.toIntExact(amountOfWords + 1));
        return dao.findById(randomId);
    }
}
