package org.lukedowell.supernat.repositories;

import org.lukedowell.supernat.entities.Election;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ldowell on 11/20/15.
 */
@Repository
public interface ElectionRepository extends CrudRepository<Election, Long> {


    @Query("SELECT e FROM Election e WHERE CURRENT_TIME between e.startDate and e.endDate")
    Election getRunningElection();
}
