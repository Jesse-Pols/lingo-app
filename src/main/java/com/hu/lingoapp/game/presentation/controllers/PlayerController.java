package com.hu.lingoapp.game.presentation.controllers;

import com.hu.lingoapp.game.application.services.PlayerService;
import com.hu.lingoapp.game.domain.models.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/get/all")
    @ResponseBody
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }
}
