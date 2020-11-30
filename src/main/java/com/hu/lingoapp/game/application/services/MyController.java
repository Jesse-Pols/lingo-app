package com.hu.lingoapp.game.application.services;

import com.hu.lingoapp.game.data.entities.GameEntity;
import com.hu.lingoapp.game.domain.dao.GameDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    private GameDao dao;

    @GetMapping("/countries")
    public String getCountries() {

        var games = (List<GameEntity>) dao.findAll();
        System.out.println("success!");
        System.out.println(games.get(0).getId());

        return "Success!";
    }
}