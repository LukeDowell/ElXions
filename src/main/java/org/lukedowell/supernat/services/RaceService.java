package org.lukedowell.supernat.services;

import org.lukedowell.supernat.entities.Election;
import org.lukedowell.supernat.entities.Race;
import org.lukedowell.supernat.repositories.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ldowell on 11/20/15.
 */
@Service
public class RaceService {

    @Autowired
    RaceRepository raceRepository;

    @Autowired
    ElectionService electionService;

    public Race createRace(String title) {
        return createRace(title, electionService.getRunningElections());
    }

    public Race createRace(String title, Election election) {
        return createRace(new Race(title, election));
    }

    public Race createRace(Race race) {
        return raceRepository.save(race);
    }
}
