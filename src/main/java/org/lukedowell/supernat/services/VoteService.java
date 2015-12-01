package org.lukedowell.supernat.services;

import org.lukedowell.supernat.entities.Game;
import org.lukedowell.supernat.entities.GameEntry;
import org.lukedowell.supernat.entities.Race;
import org.lukedowell.supernat.entities.Vote;
import org.lukedowell.supernat.repositories.GameEntryRepository;
import org.lukedowell.supernat.repositories.GameRepository;
import org.lukedowell.supernat.repositories.RaceRepository;
import org.lukedowell.supernat.repositories.VoteRepository;
import org.lukedowell.supernat.services.interfaces.IVoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ldowell on 11/19/15.
 */
@Service
public class VoteService implements IVoteService {

    private static final Logger logger = LoggerFactory.getLogger(VoteService.class);
    @Autowired
    VoteRepository voteRepository;

    @Autowired
    GameEntryRepository gameEntryRepository;

    @Override
    public Vote vote(long gameEntryId, long race_id) {
        GameEntry gameEntry = gameEntryRepository.findOne(gameEntryId);
        return vote(gameEntry);
    }

    @Override
    public Vote vote(GameEntry gameEntry) {
        Vote vote = new Vote(gameEntry);
        return voteRepository.save(vote);
    }

    @Override
    public Long getNumVotes(long gameEntryId) {
        return (long) gameEntryRepository.findOne(gameEntryId).getVotes().size();
    }
}
