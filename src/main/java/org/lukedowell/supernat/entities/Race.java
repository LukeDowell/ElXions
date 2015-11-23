package org.lukedowell.supernat.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ldowell on 11/19/15.
 */
@Entity
public class Race {

    @Id
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
            @JoinColumn(name="raceId", referencedColumnName = "raceId"),
            inverseJoinColumns =
            @JoinColumn(name="gameId", referencedColumnName = "gameId"))
    private Collection candidates;

    @OneToMany(targetEntity = Vote.class, mappedBy = "race")
    private Collection votes;

    @ManyToMany(targetEntity = SystemUser.class, fetch = FetchType.EAGER)
    @JoinTable(joinColumns =
                @JoinColumn(name="raceId", referencedColumnName = "raceId"),
                inverseJoinColumns =
                @JoinColumn(name="userId", referencedColumnName = "userId"))
    private Collection participants;

    public Race() {}

    public Race(String title, Election election) {
        this.title = title;
        this.election = election;
    }

    @Override
    public String toString() {
        return title + " race. Number of entrants: " + (candidates != null ? candidates.size() : 0);
    }

    @JsonProperty(value = "electionId")
    public long getElectionId() {
        return election.getElectionId();
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

    public Collection getParticipants() {
        return participants;
    }

    public void setParticipants(Collection participants) {
        this.participants = participants;
    }
}
