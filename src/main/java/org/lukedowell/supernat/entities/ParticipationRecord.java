package org.lukedowell.supernat.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Maintains a record of which races a given user has participated in
 * Created by ldowell on 11/25/15.
 */
@Entity
public class ParticipationRecord {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long raceParticipationId;

    @ManyToOne
    @JoinColumn(name = "raceId")
    @JsonIgnore
    private Race race;

    @ManyToOne
    @JoinColumn(name = "userId")
    @JsonIgnore
    private SystemUser user;

    public ParticipationRecord() {}

    public ParticipationRecord(Race race, SystemUser user) {
        this.race = race;
        this.user = user;

    }

    public long getRaceParticipationId() {
        return raceParticipationId;
    }

    public void setRaceParticipationId(long raceParticipationId) {
        this.raceParticipationId = raceParticipationId;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public SystemUser getUser() {
        return user;
    }

    public void setUser(SystemUser user) {
        this.user = user;
    }


}
