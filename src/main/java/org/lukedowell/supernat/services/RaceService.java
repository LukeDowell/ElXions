package org.lukedowell.supernat.services;

import org.lukedowell.supernat.entities.Election;
import org.lukedowell.supernat.entities.Game;
import org.lukedowell.supernat.entities.GameEntry;
import org.lukedowell.supernat.entities.Race;
import org.lukedowell.supernat.repositories.*;
import org.lukedowell.supernat.services.interfaces.IElectionService;
import org.lukedowell.supernat.services.interfaces.IRaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by ldowell on 11/20/15.
 */
@Service
public class RaceService implements IRaceService {

    @Autowired
    RaceRepository raceRepository;

    @Autowired
    ElectionRepository electionRepository;

    @Autowired
    GameRepository gameRepository;

    @Autowired
    SystemUserRepository userRepository;

    @Autowired
    GameEntryRepository gameEntryRepository;

    @Autowired
    IElectionService electionService;


    @Override
    public Race createRace(String title, long electionId) {
        Election election = electionRepository.findOne(electionId);
        return createRace(new Race(title, election));
    }

    @Override
    public Race createRace(Race race) {
        return raceRepository.save(race);
    }

    @Override
    public Collection<Race> getAllRaces() {
        List<Race> races = new ArrayList<>();
        for(Race r : raceRepository.findAll()) {
            races.add(r);
        }
        return races;
    }

    @Override
    public GameEntry addEntry(Game game, Race race) {
        GameEntry entry = new GameEntry(game, race);
        return gameEntryRepository.save(entry);
    }

    @Override
    public GameEntry addEntry(long gameId, long raceId) {
        return addEntry(
                gameRepository.findOne(gameId),
                raceRepository.findOne(raceId)
        );
    }
}
