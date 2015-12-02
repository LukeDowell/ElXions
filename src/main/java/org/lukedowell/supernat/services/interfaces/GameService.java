package org.lukedowell.supernat.services.interfaces;

import org.lukedowell.supernat.entities.Game;
import org.springframework.security.access.annotation.Secured;

import java.util.Collection;

/**
 * Created by ldowell on 11/23/15.
 */
public interface GameService {

    @Secured("ROLE_ADMIN")
    Game addGame(Game game);

    @Secured({"ROLE_VOTER", "ROLE_ADMIN"})
    Collection<Game> getAllGames();
}
