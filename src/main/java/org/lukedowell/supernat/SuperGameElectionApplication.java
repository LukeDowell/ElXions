package org.lukedowell.supernat;

import org.lukedowell.supernat.entities.Election;
import org.lukedowell.supernat.entities.Game;
import org.lukedowell.supernat.entities.Race;
import org.lukedowell.supernat.entities.SystemUser;
import org.lukedowell.supernat.repositories.ElectionRepository;
import org.lukedowell.supernat.repositories.GameRepository;
import org.lukedowell.supernat.repositories.RaceRepository;
import org.lukedowell.supernat.repositories.SystemUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

        actionRace.setCandidates(Arrays.asList(funGame, boringGame));
        strategyRace.setCandidates(Collections.singletonList(boringGame));

        SystemUser normalUser = new SystemUser("user", "pass", Collections.singletonList("ROLE_VOTER"));
        SystemUser admin = new SystemUser("admin", "pass", Collections.singletonList("ROLE_ADMIN"));
        SystemUser dev = new SystemUser("dev", "pass", Arrays.asList("ROLE_VOTER", "ROLE_ADMIN"));

        userRepository.save(normalUser);
        userRepository.save(admin);
        userRepository.save(dev);

        funGame = gameRepository.save(funGame);
        boringGame = gameRepository.save(boringGame);


        election = electionRepository.save(election);

        actionRace = raceRepository.save(actionRace);
        strategyRace = raceRepository.save(strategyRace);

    }
}
