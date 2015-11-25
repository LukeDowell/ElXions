package org.lukedowell.supernat.repositories;

import org.lukedowell.supernat.entities.ParticipationRecord;
import org.lukedowell.supernat.entities.Race;
import org.lukedowell.supernat.entities.SystemUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by ldowell on 11/25/15.
 */
@Repository
public interface RecordRepository extends CrudRepository<ParticipationRecord, Long> {

    @Query("SELECT r from ParticipationRecord r WHERE r.race.id = :raceId AND r.user.id = :userId")
    ParticipationRecord findRecord(@Param("raceId") long raceId, @Param("userId") long userId);

    @Query("SELECT r FROM ParticipationRecord r WHERE r.race = :race AND r.user = :user")
    ParticipationRecord findRecord(@Param("race") Race race, @Param("user") SystemUser user);

}
