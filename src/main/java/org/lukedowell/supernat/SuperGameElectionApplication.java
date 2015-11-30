package org.lukedowell.supernat;

import org.lukedowell.supernat.entities.Election;
import org.lukedowell.supernat.entities.Game;
import org.lukedowell.supernat.entities.Race;
import org.lukedowell.supernat.entities.SystemUser;
import org.lukedowell.supernat.repositories.ElectionRepository;
import org.lukedowell.supernat.repositories.GameRepository;
import org.lukedowell.supernat.repositories.RaceRepository;
import org.lukedowell.supernat.repositories.SystemUserRepository;
import org.lukedowell.supernat.services.interfaces.IRaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.Arrays;
import java.util.Collections;


@SpringBootApplication
public class SuperGameElectionApplication implements CommandLineRunner{

    @Autowired
    GameRepository gameRepository;

    @Autowired
    ElectionRepository electionRepository;

    @Autowired
    RaceRepository raceRepository;

    @Autowired
    SystemUserRepository userRepository;

    @Autowired
    IRaceService raceService;

    public static void main(String[] args) {
        SpringApplication.run(SuperGameElectionApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Election election = new Election("Video Game Elections");

        Race actionRace = new Race("Best Action Game", election);
        Race strategyRace = new Race("Best Strategy Game", election);

        Game funGame = new Game("Fun Game");
        Game boringGame = new Game("Boring Game");

        SystemUser normalUser = new SystemUser("user", "pass", AuthorityUtils.createAuthorityList("ROLE_VOTER"));
        SystemUser admin = new SystemUser("admin", "pass", AuthorityUtils.createAuthorityList("ROLE_ADMIN"));
        SystemUser dev = new SystemUser("dev", "pass", AuthorityUtils.createAuthorityList("ROLE_VOTER", "ROLE_ADMIN"));

        userRepository.save(normalUser);
        userRepository.save(admin);
        userRepository.save(dev);

        funGame = gameRepository.save(funGame);
        boringGame = gameRepository.save(boringGame);

        electionRepository.save(election);

        actionRace = raceRepository.save(actionRace);
        strategyRace = raceRepository.save(strategyRace);

        raceService.addEntry(funGame, actionRace);
        raceService.addEntry(boringGame, actionRace);

        raceService.addEntry(funGame, strategyRace);
    }
}
