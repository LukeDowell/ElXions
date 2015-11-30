package org.lukedowell.supernat.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ldowell on 11/30/15.
 */
@Entity
public class GameEntry {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long gameEntryId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "gameId")
    @JsonIgnore
    private Game game;

    @ManyToOne(optional = false)
    @JoinColumn(name = "raceId")
    @JsonIgnore
    private Race race;

    @OneToMany(targetEntity = Vote.class, mappedBy = "gameEntry")
    private Collection<Vote> votes;

    public GameEntry() {}

    public GameEntry(Game game, Race race) {
        this.game = game;
        this.race = race;
    }

    public long getGameEntryId() {
        return gameEntryId;
    }

    public void setGameEntryId(long gameEntryId) {
        this.gameEntryId = gameEntryId;
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

    public Collection<Vote> getVotes() {
        return votes;
    }

    public void setVotes(Collection<Vote> votes) {
        this.votes = votes;
    }

}
