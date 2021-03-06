package org.lukedowell.supernat.repositories;

import org.lukedowell.supernat.entities.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ldowell on 11/19/15.
 */
@Repository
public interface GameRepository extends CrudRepository<Game, Long> {
}
