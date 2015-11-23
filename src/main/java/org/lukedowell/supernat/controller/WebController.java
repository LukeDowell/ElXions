package org.lukedowell.supernat.controller;

import org.lukedowell.supernat.services.interfaces.IElectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.Map;

/**
 * Created by ldowell on 11/19/15.
 */
@Controller
public class WebController {

    @Autowired
    IElectionService electionService;

    @RequestMapping("/vote")
    @Secured({"ROLE_VOTER", "ROLE_ADMIN"})
    public String vote(Model model) {
        model.addAttribute(electionService.getRunningElections());
        return "vote";
    }

    @RequestMapping("/login")
    public String login(Map<String, Object> model) {
        return "login";
    }

    @RequestMapping("/home")
    @Secured({"ROLE_VOTER", "ROLE_ADMIN"})
    public String home(Model model, Principal principal) {

        model.addAttribute("User", principal);

        return "home";
    }

    @RequestMapping("/")
    public String index(Map<String, Object> model) {
        return "login";
    }
}

