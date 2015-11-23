package org.lukedowell.supernat.controller;

import org.lukedowell.supernat.domain.Response;
import org.lukedowell.supernat.entities.Game;
import org.lukedowell.supernat.repositories.GameRepository;
import org.lukedowell.supernat.services.GameService;
import org.lukedowell.supernat.services.interfaces.IGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by ldowell on 11/19/15.
 */
@RestController
@RequestMapping("/api/v1/game")
public class GameController {

    @Autowired
    GameRepository gameRepository;

    @Autowired
    IGameService gameService;

    @RequestMapping(method=RequestMethod.POST, value="/{title}")
    public Response<Game> add(@PathVariable String title) {
        return new Response<>(gameService.addGame(new Game(title)));
    }

    @RequestMapping(method=RequestMethod.GET)
    public Response<Collection<Game>> get() {
        return new Response<>(gameService.getAllGames());
    }
}
