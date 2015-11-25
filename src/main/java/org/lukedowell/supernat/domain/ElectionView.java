package org.lukedowell.supernat.domain;

import java.util.Collection;

/**
 * Created by ldowell on 11/25/15.
 */
public class ElectionView {

    private long id;

    private String title;

    private Collection<RaceView> races;

    public ElectionView() {}

    public ElectionView(long id, String title, Collection<RaceView> races) {
        this.id = id;
        this.title = title;
        this.races = races;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Collection<RaceView> getRaces() {
        return races;
    }

    public void setRaces(Collection<RaceView> races) {
        this.races = races;
    }
}
