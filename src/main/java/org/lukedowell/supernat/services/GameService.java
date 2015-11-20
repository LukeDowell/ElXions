package org.lukedowell.supernat.services;

import org.lukedowell.supernat.domain.Response;
import org.lukedowell.supernat.entities.Game;
import org.lukedowell.supernat.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by ldowell on 11/19/15.
 */
@Service
public class GameService {

    @Autowired
    GameRepository gameRepository;

    /**
     * @param game
     *      The game to add
     * @return
     *      The game that was added
     */
    public Game addGame(Game game) {
        return gameRepository.save(game);
    }

    /**
     * @return
     * Every game we have
     */
    public Collection<Game> getAllGames() {
        List<Game> games = new ArrayList<Game>();
        for(Game g : gameRepository.findAll()) {
            games.add(g);
        }
        return games;
    }
}
