package com.hu.lingoapp.game.application.services;

import com.hu.lingoapp.game.domain.dao.WordDao;
import com.hu.lingoapp.game.domain.models.Word;
import com.hu.lingoapp.game.domain.reader.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class WordService {

    @Autowired
    private WordDao dao;

    @Autowired
    private Reader reader;

    public List<String> readFromTxtFile(String fileName) {
        return reader.readWordsFromTxtFile(fileName);
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
        if (words == null) { return false; }
        if (words.contains(null)) { return false; }

        for (String string : words) {
            if (string.equals("")) {
                System.err.println("Skipped empty words");
                continue;
            }

            boolean success = this.save(new Word(string));
            if (!success) {
                System.err.println("FAILED TO SAVE: " + string);
            }
        }
        return true;
    }

    // Save words from txt file to DB
    public boolean saveFromTxtFile(String fileName) {
        if (fileName == null) return false;
        List<String> words = this.readFromTxtFile(fileName);
        return this.saveStringList(words);
    }

    // Use the amount of words to choose a random wordId, then get that word from the db
    public Word chooseRandomWord() {
        List<Word> words = dao.getValidWords();
        Random random = new Random();
        return words.get(random.nextInt(words.size()));
    }
}
