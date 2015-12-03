package org.lukedowell.supernat.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

/**
 * An Election is the wrapper that contains a bunch of races. An election has
 * an end date which usually is the end of the month.
 *
 * Created by ldowell on 11/19/15.
 */
@Entity
public class Election {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long electionId;

    @OneToMany(mappedBy = "election", targetEntity = Race.class)
    private Collection<Race> races;

    private String title;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    public Election() {}

    public Election(String title, LocalDateTime endDate) {
        this(title, LocalDateTime.now(), endDate);
    }

    public Election(String title) {

        LocalDate now = LocalDate.now();
        LocalDateTime endOfMonth = now.withDayOfMonth(now.lengthOfMonth()).atTime(23, 59);

        this.title = title;
        this.startDate = LocalDateTime.now();
        this.endDate = endOfMonth;
    }



    public Election(String title, LocalDateTime startDate, LocalDateTime endDate) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public long getElectionId() {
        return electionId;
    }

    public void setElectionId(long electionId) {
        this.electionId = electionId;
    }

    public Collection<Race> getRaces() {
        return races;
    }

    public void setRaces(Collection<Race> races) {
        this.races = races;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return String.format("Election: %s runs from %tD to %tD.",
                this.title,
                this.startDate,
                this.endDate);
    }
}
