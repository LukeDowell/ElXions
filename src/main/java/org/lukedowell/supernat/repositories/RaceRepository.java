package org.lukedowell.supernat.repositories;

import org.lukedowell.supernat.entities.Race;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ldowell on 11/20/15.
 */
@Repository
public interface RaceRepository extends CrudRepository<Race, Long> {
}
