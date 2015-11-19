package org.lukedowell.supernat.controller;

import org.lukedowell.supernat.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ldowell on 11/19/15.
 */
@Controller
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameRepository gameRepository;
}
