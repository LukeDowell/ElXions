package org.lukedowell.supernat.controller;

import org.lukedowell.supernat.domain.Response;
import org.lukedowell.supernat.entities.GameEntry;
import org.lukedowell.supernat.entities.Race;
import org.lukedowell.supernat.services.interfaces.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by ldowell on 11/20/15.
 */
@RestController
@RequestMapping("/api/v1/race")
public class RaceController {

    @Autowired
    RaceService raceService;

    @RequestMapping(method = RequestMethod.GET)
    public Response<Collection<Race>> getAllRaces() {
        return new Response<>(raceService.getAllRaces());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{title}/{electionId}")
    public Response<Race> createRace(@PathVariable("title") String title, @PathVariable("electionId") long electionId) {
        return new Response<>(raceService.createRace(title, electionId));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/entry/{gameId}/{raceId}")
    public Response<GameEntry> addEntry(@PathVariable("gameId") long gameId, @PathVariable("raceId") long raceId) {
        return new Response<>(raceService.addEntry(gameId, raceId));
    }
}
