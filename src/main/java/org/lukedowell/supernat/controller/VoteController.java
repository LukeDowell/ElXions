package org.lukedowell.supernat.controller;

import org.lukedowell.supernat.domain.Response;
import org.lukedowell.supernat.entities.*;
import org.lukedowell.supernat.repositories.*;
import org.lukedowell.supernat.services.interfaces.IVoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(VoteController.class);

    @Autowired
    IVoteService voteService;

    @Autowired
    RaceRepository raceRepository;

    @Autowired
    GameEntryRepository gameEntryRepository;

    @Autowired
    SystemUserRepository systemUserRepository;

    @Autowired
    RecordRepository recordRepository;


    @RequestMapping(method = RequestMethod.POST, value="/{gameEntryId}")
    public Response<Vote> vote(@PathVariable("gameEntryId") long gameEntryId,
                               Principal principal) {

        GameEntry entry = gameEntryRepository.findOne(gameEntryId);

        //Grab the user and race
        SystemUser user = systemUserRepository.findByUsername(principal.getName());
        logger.debug("voteController - Vote - User: {}", user);

        Race race = entry.getRace();
        logger.debug("voteController - Vote - Race: {}", race);

        //Allow the vote only if the user hasn't voted in the race already
        if(recordRepository.findRecord(race.getId(), user.getUserId()) == null) {

            //Attempt to submit the vote
            Vote userVote = voteService.vote(entry);
            logger.debug("voteController - Vote - UserVote: {}", userVote);

            //If it was successful
            if(userVote != null) {

                //Save the participation record
                ParticipationRecord record = new ParticipationRecord(race, user);
                logger.debug("voteController - Vote - Record: {}", record);

                recordRepository.save(record);
                //Return the envelope
                return new Response<>(userVote);
            } else {
                return new Response<>(Response.FAILED, "Voting service is broken. :( ", null);
            }

        } else {
            return new Response<>(Response.FAILED, "You have already voted in this race!", null);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value="/{gameEntryId}")
    public Response<Long> numVotes(@PathVariable("gameEntryId") long gameEntryId) {
        return new Response<>(voteService.getNumVotes(gameEntryId));
    }
}
