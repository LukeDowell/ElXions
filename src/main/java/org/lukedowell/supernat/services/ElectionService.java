package org.lukedowell.supernat.services;

import org.lukedowell.supernat.entities.Election;
import org.lukedowell.supernat.repositories.ElectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by ldowell on 11/20/15.
 */
@Service
public class ElectionService {

    @Autowired
    ElectionRepository electionRepository;

    public Election addElection(Election election) {
        //TODO: if getRunningElections() != null
        return electionRepository.save(election);
    }

    public Election getRunningElections() {
        return electionRepository.getRunningElections();
    }

    public Collection<Election> getAllElections() {
        List<Election> elections = new ArrayList<Election>();
        for(Election e : electionRepository.findAll()) {
            elections.add(e);
        }
        return elections;
    }
}
