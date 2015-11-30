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
    @JoinColumn(name = "gameEntryId")
    @JsonIgnore
    private GameEntry gameEntry;

    @ManyToOne(optional = false)
    @JoinColumn(name = "raceId")
    @JsonIgnore
    private Race race;

    public Vote() {}

    public Vote(GameEntry gameEntry) {
        this.gameEntry = gameEntry;
        this.race = gameEntry.getRace();
    }

    public long getVoteId() {
        return voteId;
    }

    public void setVoteId(long voteId) {
        this.voteId = voteId;
    }

    public GameEntry getGameEntry() {
        return gameEntry;
    }

    public void setGame(GameEntry gameEntry) {
        this.gameEntry = gameEntry;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }
}
