package org.lukedowell.supernat.services.interfaces;

import org.lukedowell.supernat.entities.Game;
import org.lukedowell.supernat.entities.GameEntry;
import org.lukedowell.supernat.entities.Race;
import org.springframework.security.access.annotation.Secured;

import java.util.Collection;

/**
 * Created by ldowell on 11/23/15.
 */

public interface IRaceService {

    @Secured("ROLE_ADMIN")
    Race createRace(String title, long electionId);

    @Secured("ROLE_ADMIN")
    Race createRace(Race race);

    @Secured({"ROLE_VOTER", "ROLE_ADMIN"})
    Collection<Race> getAllRaces();

    @Secured({"ROLE_ADMIN"})
    GameEntry addEntry(Game game, Race race);

    @Secured({"ROLE_ADMIN"})
    GameEntry addEntry(long gameId, long raceId);
}
