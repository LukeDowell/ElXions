package org.lukedowell.supernat.controller;

import org.lukedowell.supernat.entities.Election;
import org.lukedowell.supernat.entities.Race;
import org.lukedowell.supernat.repositories.GameRepository;
import org.lukedowell.supernat.services.interfaces.IElectionService;
import org.lukedowell.supernat.services.interfaces.IGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 * Created by ldowell on 11/19/15.
 */
@Controller
public class WebController {

    @Autowired
    IElectionService electionService;

    @Autowired
    IGameService gameService;

    @RequestMapping("/vote")
    @Secured({"ROLE_VOTER", "ROLE_ADMIN"})
    public String vote(Model model) {
        model.addAttribute(electionService.getRunningElections());
        return "vote";
    }

    @RequestMapping("/home")
    @Secured({"ROLE_VOTER", "ROLE_ADMIN"})
    public String home(Model model, Principal principal) {
        model.addAttribute("user", principal);
        return "home";
    }

    @RequestMapping("/games")
    @Secured({"ROLE_VOTER", "ROLE_ADMIN"})
    public String games(Model model, Principal principal) {
        model.addAttribute("user", principal);
        model.addAttribute("gameList", gameService.getAllGames());
        return "games";
    }

    @RequestMapping("/admin")
    @Secured({"ROLE_ADMIN"})
    public String admin(Model model, Principal principal) {

        Collection<Election> runningElections = electionService.getRunningElections();
        Collection<Race> currentRaces = new ArrayList<>();

        //For each running election, add all of their races to the current races collection
        runningElections.forEach((election -> election.getRaces().forEach((currentRaces::add))));

        model.addAttribute("user", principal);
        model.addAttribute("currentElections", runningElections);
        model.addAttribute("currentRaces", currentRaces);
        return "admin";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/")
    public String index() {
        return "login";
    }
}

