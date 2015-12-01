package org.lukedowell.supernat.repositories;

import org.lukedowell.supernat.entities.Game;
import org.lukedowell.supernat.entities.Race;
import org.lukedowell.supernat.entities.Vote;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by ldowell on 11/20/15.
 */
@Repository
public interface VoteRepository extends CrudRepository<Vote, Long> {

//    @Query("SELECT COUNT(v) FROM Vote v WHERE v.game = :gameId AND v.race = :raceId")
//    Long countVotes( @Param("gameId") Game game, @Param("raceId") Race race);


}
