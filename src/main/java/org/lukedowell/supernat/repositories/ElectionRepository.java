package org.lukedowell.supernat.repositories;

import org.lukedowell.supernat.entities.Election;
import org.lukedowell.supernat.entities.SystemUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by ldowell on 11/20/15.
 */
@Repository
public interface ElectionRepository extends CrudRepository<Election, Long> {


    @Query("SELECT e FROM Election e WHERE CURRENT_TIME between e.startDate and e.endDate")
    Collection<Election> getRunningElections();

}
