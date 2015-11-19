package org.lukedowell.supernat;

import org.lukedowell.supernat.entities.Game;
import org.lukedowell.supernat.entities.Genre;
import org.lukedowell.supernat.entities.SystemUser;
import org.lukedowell.supernat.repositories.GameRepository;
import org.lukedowell.supernat.repositories.GenreRepository;
import org.lukedowell.supernat.repositories.SystemUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SuperGameElectionApplication implements CommandLineRunner{

    @Autowired
    GameRepository gameRepository;

    @Autowired
    SystemUserRepository systemUserRepository;

    @Autowired
    GenreRepository genreRepository;

    public static void main(String[] args) {
        SpringApplication.run(SuperGameElectionApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        SystemUser user = new SystemUser();
        user.setId(1);
        user.setName("user");
        user.setPassword("password");
        systemUserRepository.save(user);

        Genre actionGenre = new Genre();
        actionGenre.setId(1);
        actionGenre.setName("Action");
        genreRepository.save(actionGenre);

        Game someGame = new Game();
        someGame.setId(1);
        someGame.setGenre(actionGenre);
        someGame.setCreatedOn(new Date());
        someGame.setOwned(false);
        someGame.setTitle("Crazy Action Game");
        gameRepository.save(someGame);

    }
}
