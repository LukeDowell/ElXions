package org.lukedowell.supernat.mock;

import org.lukedowell.supernat.entities.Election;
import org.lukedowell.supernat.repositories.ElectionRepository;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ldowell on 11/24/15.
 */
public class MockElectionRepository implements ElectionRepository {

    private List<Election> elections;

    public MockElectionRepository() {
        elections = new LinkedList<>();
    }

    @Override
    public Collection<Election> getRunningElections() {
        return null;
    }

    @Override
    public <S extends Election> S save(S entity) {
        elections.add(entity);
        return entity;
    }

    @Override
    public <S extends Election> Iterable<S> save(Iterable<S> entities) {
        entities.forEach((entity) -> elections.add(entity));
        return entities;
    }

    @Override
    public Election findOne(Long aLong) {
        return null;
    }

    @Override
    public boolean exists(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Election> findAll() {
        return null;
    }

    @Override
    public Iterable<Election> findAll(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public void delete(Election entity) {

    }

    @Override
    public void delete(Iterable<? extends Election> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
