package org.lukedowell.supernat.services;

import org.lukedowell.supernat.domain.ElectionView;
import org.lukedowell.supernat.domain.GameCard;
import org.lukedowell.supernat.domain.RaceView;
import org.lukedowell.supernat.entities.Election;
import org.lukedowell.supernat.entities.GameEntry;
import org.lukedowell.supernat.entities.Race;
import org.lukedowell.supernat.services.interfaces.IVoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by ldowell on 11/25/15.
 */
@Service
public class ViewModelService {

    private static final Logger logger = LoggerFactory.getLogger(ViewModelService.class);

    @Autowired
    IVoteService voteService;

    public ElectionView buildElectionView(Election e, boolean recursive) {
        ElectionView electionView = new ElectionView();

        electionView.setTitle(e.getTitle());
        electionView.setId(e.getElectionId());
        electionView.setRaces(buildRacesForElection(e, recursive));

        logger.debug(electionView.toString());

        return electionView;
    }


    public RaceView buildRaceView(Race r, boolean includeGames) {
        RaceView raceView = new RaceView();

        raceView.setTitle(r.getTitle());
        raceView.setId(r.getId());
        if(includeGames) {
            raceView.setEntries(buildGamesForRace(r));
        }

        return raceView;
    }

    public GameCard buildGameCard(GameEntry gameEntry) {
        return new GameCard(gameEntry);
    }

    protected Collection<RaceView> buildRacesForElection(Election e, boolean recursive) {
        List<RaceView> races = new ArrayList<>();

        e.getRaces().forEach((race) -> races.add(buildRaceView(race, recursive)));

        return races;
    }

    protected Collection<GameCard> buildGamesForRace(Race r) {
        List<GameCard> cards = new ArrayList<>();

        r.getEntries().forEach((gameEntry) -> cards.add(buildGameCard(gameEntry)));

        return cards;
    }
}
