package org.lukedowell.supernat.repositories;

import org.lukedowell.supernat.entities.SystemUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ldowell on 11/23/15.
 */
@Repository
public interface SystemUserRepository extends CrudRepository<SystemUser, Long> {

    SystemUser findByUsername(String usename);

}
