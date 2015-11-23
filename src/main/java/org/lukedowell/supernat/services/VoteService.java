package org.lukedowell.supernat.services;

import org.lukedowell.supernat.entities.Game;
import org.lukedowell.supernat.entities.Race;
import org.lukedowell.supernat.entities.Vote;
import org.lukedowell.supernat.repositories.GameRepository;
import org.lukedowell.supernat.repositories.RaceRepository;
import org.lukedowell.supernat.repositories.VoteRepository;
import org.lukedowell.supernat.services.interfaces.IVoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ldowell on 11/19/15.
 */
@Service
public class VoteService implements IVoteService {

    @Autowired
    VoteRepository voteRepository;

    @Autowired
    RaceRepository raceRepository;

    @Autowired
    GameRepository gameRepository;

    @Override
    public Vote vote(long game_id, long race_id) {
        Game game = gameRepository.findOne(game_id);
        Race race = raceRepository.findOne(race_id);
        return vote(game, race);
    }

    @Override
    public Vote vote(Game game, Race race) {
        Vote vote = new Vote(game, race);
        return voteRepository.save(vote);
    }
}
