package org.lukedowell.supernat.repositories;

import org.lukedowell.supernat.entities.GameEntry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ldowell on 11/30/15.
 */
@Repository
public interface GameEntryRepository extends CrudRepository<GameEntry, Long> {
}
