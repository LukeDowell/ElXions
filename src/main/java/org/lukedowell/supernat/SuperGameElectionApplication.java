package org.lukedowell.supernat;

import org.lukedowell.supernat.entities.*;
import org.lukedowell.supernat.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;


@SpringBootApplication
public class SuperGameElectionApplication implements CommandLineRunner{

    @Autowired
    GameRepository gameRepository;

    @Autowired
    ElectionRepository electionRepository;

    @Autowired
    RaceRepository raceRepository;

    @Autowired
    SystemUserRepository systemUserRepository;

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

        SystemUser user = new SystemUser("user", "pass");
        SystemUser admin = new SystemUser("admin", "pass");

        Vote vote1 = new Vote(funGame, actionRace, user);
        Vote vote2 = new Vote(funGame, actionRace, admin);
        Vote vote3 = new Vote(boringGame, strategyRace, user);

        electionRepository.save(election);

        raceRepository.save(actionRace);
        raceRepository.save(strategyRace);

        gameRepository.save(funGame);
        gameRepository.save(boringGame);

        systemUserRepository.save(user);
        systemUserRepository.save(admin);

        voteRepository.save(vote1);
        voteRepository.save(vote2);
        voteRepository.save(vote3);

    }
}
