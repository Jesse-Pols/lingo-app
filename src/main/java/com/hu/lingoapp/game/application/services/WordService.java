package com.hu.lingoapp.game.application.services;

import com.hu.lingoapp.game.domain.dao.WordDao;
import com.hu.lingoapp.game.domain.models.Word;
import com.hu.lingoapp.game.domain.reader.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class WordService {

    // Wordlist can be minimized
    // This is a temporary solution to any limits imposed by the used database

    @Autowired
    private WordDao dao;

    @Autowired
    private Reader reader;

    @Autowired
    private VerificationService verificationService;

    public List<String> readFromTxtFile(String fileName, boolean minimized) {
        return reader.readWordsFromTxtFile(fileName, minimized);
    }

    // Only unique words can be saved. Otherwise it just throws an exception.
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

    public boolean saveStringList(List<String> words, String bundle) {
        if (words == null || bundle == null) { return false; }
        if (words.contains(null)) { return false; }

        for (String string : words) {
            if (string.equals("")) {
                System.err.println("Skipped empty words");
                continue;
            }

            boolean success = this.save(new Word(string, bundle));
            if (!success) {
                System.err.println("FAILED TO SAVE: " + string);
            }
        }
        return true;
    }

    // Save words from txt file to DB
    public boolean saveFromTxtFile(String fileName, boolean minimized) {
        if (fileName == null) return false;
        List<String> words = this.readFromTxtFile(fileName, minimized);

        // We'll name the bundle after the filename
        return this.saveStringList(words, fileName);
    }

    // Use the amount of words to choose a random wordId, then get that word from the db
    public Word chooseRandomWord(int answerLength) {
        List<Word> words = null;
        if (answerLength == 5) words = dao.getValidWordsOf5Letters();
        if (answerLength == 6) words = dao.getValidWordsOf6Letters();
        if (answerLength == 7) words = dao.getValidWordsOf7Letters();
        if (words == null) dao.getValidWords();
        
        Random random = new Random();
        return words.get(random.nextInt(words.size()));
    }

    // Heroku databases have a rowlimit of 10.000
    // These wordlists can sometimes be very very large, so for the sake of 'not-having-to-upgrade-heroku' we delete some of the lines, that wouldn't be used anyway.
    // We remove any line that can't be verified by our own verificationservice
    public boolean deleteInvalidWords(String fileName) {
        List<String> lines = readFromTxtFile(fileName, false);
        List<String> validLines = new ArrayList<>();

        for (String line : lines) {
            if (verificationService.verifyRegex(line)) validLines.add(line);
        }

        try {
            File file = new File("wordlist/minimized-words/" + fileName);
            file.createNewFile();

            FileWriter writer = new FileWriter(file);
            for (String line : validLines) {
                writer.write(line + System.lineSeparator());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
