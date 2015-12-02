package org.lukedowell.supernat.services.interfaces;

import org.lukedowell.supernat.entities.Election;
import org.springframework.security.access.annotation.Secured;

import java.util.Collection;

/**
 * Created by ldowell on 11/23/15.
 */
public interface ElectionService {

    @Secured("ROLE_ADMIN")
    Election addElection(Election e);

    @Secured({"ROLE_VOTER", "ROLE_ADMIN"})
    Collection<Election> getRunningElections();

    @Secured("ROLE_ADMIN")
    Collection<Election> getAllElections();
}
