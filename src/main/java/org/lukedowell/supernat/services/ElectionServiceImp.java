package org.lukedowell.supernat.services;

import org.lukedowell.supernat.entities.Election;
import org.lukedowell.supernat.repositories.ElectionRepository;
import org.lukedowell.supernat.services.interfaces.ElectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by ldowell on 11/20/15.
 */
@Service
public class ElectionServiceImp implements ElectionService {

    @Autowired
    ElectionRepository electionRepository;

    @Override
    public Election addElection(Election election) {
        return electionRepository.save(election);
    }

    @Override
    public Collection<Election> getRunningElections() {
        return electionRepository.getRunningElections();
    }

    @Override
    public Collection<Election> getAllElections() {
        List<Election> elections = new ArrayList<>();
        for(Election e : electionRepository.findAll()) {
            elections.add(e);
        }
        return elections;
    }
}
