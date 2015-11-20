package org.lukedowell.supernat.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 *
 * A single vote. A systemUser may create a vote for a given game
 * and electoral period.
 *
 * Created by ldowell on 11/19/15.
 */
@Entity
public class Vote {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "gameId")
    @JsonIgnore
    private Game game;

    @ManyToOne(optional = false)
    @JoinColumn(name = "systemUserId")
    @JsonIgnore
    private SystemUser systemUser;

    @ManyToOne(optional = false)
    @JoinColumn(name = "raceId")
    @JsonIgnore
    private Race race;

    public Vote() {}

    public Vote(Game game, Race race, SystemUser user) {
        this.game = game;
        this.systemUser = user;
        this.race = race;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public SystemUser getSystemUser() {
        return systemUser;
    }

    public void setSystemUser(SystemUser systemUser) {
        this.systemUser = systemUser;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }
}
