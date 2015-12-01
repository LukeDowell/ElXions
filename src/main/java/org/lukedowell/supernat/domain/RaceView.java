package org.lukedowell.supernat.domain;

import java.util.Collection;

/**
 * Created by ldowell on 11/25/15.
 */
public class RaceView {

    private long id;

    private String title;

    private Collection<GameCard> entries;

    public RaceView() {}

    public RaceView(long id, String title, Collection<GameCard> entries) {
        this.id = id;
        this.title = title;
        this.entries = entries;
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

    public Collection<GameCard> getEntries() {
        return entries;
    }

    public void setEntries(Collection<GameCard> entries) {
        this.entries = entries;
    }

    @Override
    public String toString() {
        StringBuilder race = new StringBuilder();
        race.append(String.format("%d -- Race: %s -- Game List: ", this.getId(), this.getTitle()));
        this.getEntries().forEach(game -> race.append(game.toString()));

        return race.toString();
    }
}
