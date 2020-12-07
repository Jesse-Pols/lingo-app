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

    // TODO save function with an {text} parameter
    @GetMapping("/save")
    @ResponseBody
    public boolean save(@RequestParam String word) {
        return wordService.save(new Word(word));
    }

    @GetMapping("/save/file")
    @ResponseBody
    public boolean saveFile(@RequestParam String path) {
        return wordService.saveFromTxtFile(path);
    }
}
