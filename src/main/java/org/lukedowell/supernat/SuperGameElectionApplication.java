package org.lukedowell.supernat;

import org.lukedowell.supernat.entities.*;
import org.lukedowell.supernat.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


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
        electionRepository.save(election);

        Race actionRace = new Race("Best Action Game", election);
        raceRepository.save(actionRace);

        Game funGame = new Game("Fun Game");
        gameRepository.save(funGame);

        Game boringGame = new Game("Boring Game");
        gameRepository.save(boringGame);

        SystemUser user = new SystemUser("user", "pass");
        systemUserRepository.save(user);

        Vote vote = new Vote(funGame, user, actionRace);
        voteRepository.save(vote);

    }
}
