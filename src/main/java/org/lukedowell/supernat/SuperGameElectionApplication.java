package org.lukedowell.supernat;

import org.lukedowell.supernat.entities.Election;
import org.lukedowell.supernat.entities.Game;
import org.lukedowell.supernat.repositories.ElectionRepository;
import org.lukedowell.supernat.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Calendar;
import java.util.Date;

@SpringBootApplication
public class SuperGameElectionApplication implements CommandLineRunner{

    @Autowired
    GameRepository gameRepository;

    @Autowired
    ElectionRepository electionRepository;

    public static void main(String[] args) {
        SpringApplication.run(SuperGameElectionApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), Calendar.NOVEMBER, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date endOfMonth = calendar.getTime();
        Election election = new Election("Best Video Game", endOfMonth);
        electionRepository.save(election);


        Game someGame = new Game();
        someGame.setId(1);
        someGame.setTitle("Crazy Action Game");
        gameRepository.save(someGame);

    }
}
