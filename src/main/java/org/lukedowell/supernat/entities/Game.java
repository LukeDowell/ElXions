package org.lukedowell.supernat.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Collection;

/**
 *
 * A representation of a game. Games can be created and voted
 * on by users. Games can only belong to a single genre for
 * simplicity's sake.
 *
 * Created by ldowell on 11/19/15.
 */
@Entity
public class Game {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long gameId;

    @OneToMany(mappedBy = "game", targetEntity = Vote.class, fetch = FetchType.EAGER)
    private Collection votes;

    @ManyToMany(mappedBy = "candidates", targetEntity = Race.class, fetch = FetchType.EAGER)
    private Collection races;

    private String title;

    public Game() {}

    public Game(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Game: " + title;
    }

    public long getId() {
        return gameId;
    }

    public void setId(long id) {
        this.gameId = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}