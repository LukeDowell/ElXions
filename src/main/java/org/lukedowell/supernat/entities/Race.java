package org.lukedowell.supernat.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Collection;

/**
 *
 * A race attaches itself to an election period and a genre. Many games
 * can be voted on in the race as long as they share the same genre. A
 * race ends at the same time as an election.
 *
 * Created by ldowell on 11/19/15.
 */
@Entity
public class Race {

    @Id
    @Column(name = "RACE_ID", nullable = false)
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long raceId;

    private String title;

    @ManyToOne(optional = false)
    @JoinColumn(name = "electionId")
    @JsonIgnore
    private Election election;

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = Game.class)
    @JoinTable(name = "RACE_CANDIDATES",
            joinColumns=
            @JoinColumn(name="RACE_ID", referencedColumnName = "RACE_ID"),
            inverseJoinColumns =
            @JoinColumn(name="GAME_ID", referencedColumnName = "GAME_ID"))
    private Collection candidates;

    @OneToMany(targetEntity = Vote.class, mappedBy = "race")
    private Collection votes;

    public Race() {}

    public Race(String title, Election election) {
        this.title = title;
        this.election = election;
    }

    @JsonProperty(value = "electionId")
    public long getElectionId() {
        return election.getId();
    }

    public long getId() {
        return raceId;
    }

    public void setId(long id) {
        this.raceId = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Election getElection() {
        return election;
    }

    public void setElection(Election election) {
        this.election = election;
    }

    public Collection<Game> getCandidates() {
        return candidates;
    }

    public void setCandidates(Collection<Game> candidates) {
        this.candidates = candidates;
    }

    public Collection<Vote> getVotes() {
        return votes;
    }

    public void setVotes(Collection<Vote> votes) {
        this.votes = votes;
    }
}
