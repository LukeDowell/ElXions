package org.lukedowell.supernat.services.interfaces;

import org.lukedowell.supernat.entities.Game;
import org.lukedowell.supernat.entities.Race;
import org.lukedowell.supernat.entities.SystemUser;
import org.lukedowell.supernat.entities.Vote;
import org.springframework.security.access.annotation.Secured;

/**
 * Created by ldowell on 11/23/15.
 */
@Secured("ROLE_VOTER")
public interface IVoteService {

    Vote vote(long gameId, long raceId, SystemUser user);

    Vote vote(Game game, Race race, SystemUser user);
}
