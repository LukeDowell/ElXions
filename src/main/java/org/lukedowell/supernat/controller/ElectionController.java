package org.lukedowell.supernat.controller;

import org.lukedowell.supernat.domain.Response;
import org.lukedowell.supernat.entities.Election;
import org.lukedowell.supernat.services.ElectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by ldowell on 11/20/15.
 */
@RestController
@RequestMapping("/api/v1/election")
public class ElectionController {

    @Autowired
    ElectionService electionService;

    @RequestMapping(method = RequestMethod.POST)
    public Response<Election> createElection(@RequestBody Election election) {
        return new Response<Election>(electionService.addElection(election));
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
