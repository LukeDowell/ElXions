package org.lukedowell.supernat.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

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
    private Collection races;

    private String title;

    private Date startDate;

    private Date endDate;

    public Election() {}

    public Election(String title, Date endDate) {
        this(title, new Date(), endDate);
    }

    public Election(String title) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), Calendar.NOVEMBER, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date endOfMonth = calendar.getTime();

        this.title = title;
        this.startDate = new Date();
        this.endDate = endOfMonth;
    }



    public Election(String title, Date startDate, Date endDate) {
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
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
