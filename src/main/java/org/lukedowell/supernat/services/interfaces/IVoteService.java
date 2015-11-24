package org.lukedowell.supernat.services.interfaces;

import org.lukedowell.supernat.entities.Game;
import org.lukedowell.supernat.entities.Race;
import org.lukedowell.supernat.entities.SystemUser;
import org.lukedowell.supernat.entities.Vote;
import org.springframework.security.access.annotation.Secured;

/**
 * Created by ldowell on 11/23/15.
 */
public interface IVoteService {

    @Secured("ROLE_VOTER")
    Vote vote(long gameId, long raceId);

    @Secured("ROLE_VOTER")
    Vote vote(Game game, Race race);

    @Secured({"ROLE_VOTER", "ROLE_ADMIN"})
    Long getNumVotes(long gameId, long raceId);
}
