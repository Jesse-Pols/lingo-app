package com.hu.lingoapp.game.presentation.controllers;

import com.hu.lingoapp.game.application.services.WordService;
import com.hu.lingoapp.game.domain.models.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("word")
public class WordController {
    @Autowired
    private WordService wordService;

    @PostMapping("/save")
    @ResponseBody
    public boolean save(@RequestParam String word) {
        return wordService.save(new Word(word));
    }

    @PostMapping("/save/file")
    @ResponseBody
    public boolean saveFile(@RequestParam String path, @RequestParam boolean minimized) {
        return wordService.saveFromTxtFile(path, minimized);
    }

    @GetMapping("/get/random")
    @ResponseBody
    public Word getRandomWords() { return wordService.chooseRandomWord(5); }

    @DeleteMapping("/delete/invalid")
    @ResponseBody
    public boolean deleteInvalidWords(@RequestParam String path) { return wordService.deleteInvalidWords(path); }
}
