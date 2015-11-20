package org.lukedowell.supernat.controller;

import org.lukedowell.supernat.domain.Response;
import org.lukedowell.supernat.entities.Game;
import org.lukedowell.supernat.repositories.GameRepository;
import org.lukedowell.supernat.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    GameService gameService;

    @RequestMapping(method=RequestMethod.POST, value="/{title}")
    public Response<Game> add(@PathVariable String title) {
        return new Response<Game>(gameService.addGame(new Game(title)));
    }

    @RequestMapping(method=RequestMethod.GET)
    public Response<Collection<Game>> get() {
        return new Response<Collection<Game>>(gameService.getAllGames());
    }
}
