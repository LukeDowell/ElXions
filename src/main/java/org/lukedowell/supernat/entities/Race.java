package org.lukedowell.supernat.entities;

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
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;

    private String title;

    @ManyToOne
    private Election election;

    @OneToMany
    private Collection<Game> candidates;

    @OneToMany
    private Collection<Vote> votes;

    public Race() {}

    public Race(String title, Election election) {
        this.title = title;
        this.election = election;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
