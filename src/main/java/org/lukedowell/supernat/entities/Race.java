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

    @OneToMany(targetEntity = GameEntry.class, mappedBy = "race")
    private Collection<GameEntry> entries;

    @OneToMany(targetEntity = Vote.class, mappedBy = "race")
    private Collection<Vote> votes;

    @OneToMany(mappedBy = "race", targetEntity = ParticipationRecord.class)
    private Collection<ParticipationRecord> records;

    public Race() {}

    public Race(String title, Election election) {
        this.title = title;
        this.election = election;
    }

    @Override
    public String toString() {
        return title + " race. Number of entrants: " + (entries != null ? entries.size() : 0);
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

    public Collection<GameEntry> getEntries() {
        return entries;
    }

    public void setEntries(Collection<GameEntry> entries) {
        this.entries = entries;
    }

    public Collection<ParticipationRecord> getRecords() {
        return records;
    }

    public void setRecords(Collection<ParticipationRecord> records) {
        this.records = records;
    }

    public Collection<Vote> getVotes() {
        return votes;
    }

    public void setVotes(Collection<Vote> votes) {
        this.votes = votes;
    }
}
