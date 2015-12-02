package org.lukedowell.supernat.services;

import org.lukedowell.supernat.entities.Game;
import org.lukedowell.supernat.repositories.GameRepository;
import org.lukedowell.supernat.services.interfaces.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by ldowell on 11/19/15.
 */
@Service
public class GameServiceImp implements GameService {

    @Autowired
    GameRepository gameRepository;

    /**
     * @param game
     *      The game to add
     * @return
     *      The game that was added
     */
    @Override
    public Game addGame(Game game) {
        return gameRepository.save(game);
    }

    /**
     * @return
     * Every game we have
     */
    @Override
    public Collection<Game> getAllGames() {
        List<Game> games = new ArrayList<>();
        for(Game g : gameRepository.findAll()) {
            games.add(g);
        }
        return games;
    }
}
