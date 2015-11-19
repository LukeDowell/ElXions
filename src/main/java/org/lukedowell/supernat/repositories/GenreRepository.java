package org.lukedowell.supernat.repositories;

import org.lukedowell.supernat.entities.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ldowell on 11/19/15.
 */
@Repository
public interface GenreRepository extends CrudRepository<Genre, Long>{
}
