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
    private long voteId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "gameId")
    @JsonIgnore
    private Game game;

    @ManyToOne(optional = false)
    @JoinColumn(name = "raceId")
    @JsonIgnore
    private Race race;

    public Vote() {}

    public Vote(Game game, Race race) {
        this.game = game;
        this.race = race;
    }

    public long getVoteId() {
        return voteId;
    }

    public void setVoteId(long voteId) {
        this.voteId = voteId;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }
}
