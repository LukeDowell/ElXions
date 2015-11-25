package org.lukedowell.supernat.services;

import org.lukedowell.supernat.domain.ElectionView;
import org.lukedowell.supernat.domain.GameCard;
import org.lukedowell.supernat.domain.RaceView;
import org.lukedowell.supernat.entities.Election;
import org.lukedowell.supernat.entities.Game;
import org.lukedowell.supernat.entities.Race;
import org.lukedowell.supernat.services.interfaces.IVoteService;
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

    @Autowired
    IVoteService voteService;

    public ElectionView buildElectionView(Election e, boolean recursive) {
        ElectionView electionView = new ElectionView();

        electionView.setTitle(e.getTitle());
        electionView.setId(e.getElectionId());
        if(recursive) {
            electionView.setRaces(buildRacesForElection(e, recursive));
        }

        return electionView;
    }


    public RaceView buildRaceView(Race r, boolean includeGames) {
        RaceView raceView = new RaceView();

        raceView.setTitle(r.getTitle());
        raceView.setId(r.getId());
        if(includeGames) {
            raceView.setGames(buildGamesForRace(r));
        }

        return raceView;
    }

    public GameCard buildGameCard(Game game, long raceId) {
        long numVotes = voteService.getNumVotes(game.getId(), raceId);
        return new GameCard(game, numVotes);
    }

    protected Collection<RaceView> buildRacesForElection(Election e, boolean recursive) {
        List<RaceView> races = new ArrayList<>();

        e.getRaces().forEach((race) -> races.add(buildRaceView(race, recursive)));

        return races;
    }

    protected Collection<GameCard> buildGamesForRace(Race r) {
        List<GameCard> cards = new ArrayList<>();

        r.getCandidates().forEach((game) -> cards.add(buildGameCard(game, r.getId())));

        return cards;
    }
}
