package org.lukedowell.supernat;

import org.lukedowell.supernat.entities.*;
import org.lukedowell.supernat.repositories.*;
import org.lukedowell.supernat.services.interfaces.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.authority.AuthorityUtils;


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
    RaceService raceService;

    @Autowired
    VoteRepository voteRepository;

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

        GameEntry entry = raceService.addEntry(funGame, actionRace);
        GameEntry entryTwo = raceService.addEntry(boringGame, actionRace);
        GameEntry entryThree = raceService.addEntry(funGame, strategyRace);

        Vote vote1 = new Vote(entry);
        Vote vote2 = new Vote(entry);
        Vote vote3 = new Vote(entryTwo);
        Vote vote4 = new Vote(entryThree);

        voteRepository.save(vote1);
        voteRepository.save(vote2);
        voteRepository.save(vote3);
        voteRepository.save(vote4);
    }
}
