package org.lukedowell.supernat.controller;

import org.lukedowell.supernat.domain.Response;
import org.lukedowell.supernat.entities.Game;
import org.lukedowell.supernat.entities.Race;
import org.lukedowell.supernat.entities.SystemUser;
import org.lukedowell.supernat.entities.Vote;
import org.lukedowell.supernat.repositories.GameRepository;
import org.lukedowell.supernat.repositories.RaceRepository;
import org.lukedowell.supernat.repositories.SystemUserRepository;
import org.lukedowell.supernat.services.interfaces.IVoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by ldowell on 11/19/15.
 */
@RestController
@RequestMapping("/api/v1/vote")
public class VoteController {

    @Autowired
    IVoteService voteService;

    @Autowired
    RaceRepository raceRepository;

    @Autowired
    GameRepository gameRepository;

    @Autowired
    SystemUserRepository systemUserRepository;


    @RequestMapping(method = RequestMethod.POST, value="/{raceId}/{gameId}")
    public Response<Vote> vote(@PathVariable("raceId") long raceId,
                               @PathVariable("gameId") long gameId,
                               Principal principal) {

        //Grab the user
        SystemUser user = systemUserRepository.findByUsername(principal.getName());

        //Grab the game and race
        Game game = gameRepository.findOne(gameId);
        Race race = raceRepository.findOne(raceId);

        //Allow the vote only if the user hasn't voted in the race already
        if(!race.getParticipants().contains(user)) {
            race.getParticipants().add(user);
            raceRepository.save(race);
            return new Response<>(voteService.vote(game, race));
        } else {
            return new Response<>(Response.FAILED, "You cannot vote in the same race twice!", null);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value="/{raceId}/{gameId}")
    public Response<Long> numVotes(@PathVariable("raceId") long raceId,
                                      @PathVariable("gameId") long gameId) {
        return new Response<>(voteService.getNumVotes(gameId, raceId));
    }
}
