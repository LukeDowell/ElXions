package org.lukedowell.supernat.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

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

    private String title;

    private Date created; //The date the game was added to the library

    public Game() {}

    public Game(String title) {
        this.title = title;
        created = new Date();
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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}