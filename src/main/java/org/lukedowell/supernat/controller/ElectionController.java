package org.lukedowell.supernat.controller;

import org.lukedowell.supernat.domain.Response;
import org.lukedowell.supernat.entities.Election;
import org.lukedowell.supernat.services.ElectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by ldowell on 11/20/15.
 */
@RestController
@RequestMapping("/api/v1/election")
public class ElectionController {

    @Autowired
    ElectionService electionService;

    @RequestMapping(method = RequestMethod.POST, value="/{title}")
    public Response<Election> createElection(@RequestBody(required = false) Election election, @PathVariable String title) {
        Response<Election> response;
        if(election != null) {
            response = new Response<Election>(electionService.addElection(election));
        } else if(title != null) {
            response = new Response<Election>(electionService.addElection(new Election(title)));
        } else {
            response = new Response<Election>(Response.FAILED,
                    "There was a problem with your input. Please try again.",
                    null);
        }
        return response;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Response<Collection<Election>> getElections() {
        return new Response<Collection<Election>>(electionService.getAllElections());
    }

    @RequestMapping(method = RequestMethod.GET, value="/running")
    public Response<Election> getRunningElection() {
        return new Response<Election>(electionService.getRunningElection());
    }
}
