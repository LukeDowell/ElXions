package org.lukedowell.supernat.controller;

import org.lukedowell.supernat.domain.Response;
import org.lukedowell.supernat.entities.SystemUser;
import org.lukedowell.supernat.entities.Vote;
import org.lukedowell.supernat.repositories.SystemUserRepository;
import org.lukedowell.supernat.services.VoteService;
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
    VoteService voteService;

    @Autowired
    SystemUserRepository systemUserRepository;

    @RequestMapping(method = RequestMethod.POST, value="/{raceId}/{gameId}")
    public Response<Vote> vote(@PathVariable("raceId") long raceId,
                               @PathVariable("gameId") long gameId,
                               Principal principal) {

        SystemUser user = systemUserRepository.findSystemUserByName(principal.getName());
        System.out.println(user.getName());
        return new Response<>(voteService.vote(raceId, gameId, user));
    }
}
