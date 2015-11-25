package org.lukedowell.supernat.domain;

import java.util.Collection;

/**
 * Created by ldowell on 11/25/15.
 */
public class RaceView {

    private long id;

    private String title;

    private Collection<GameCard> games;

    public RaceView() {}

    public RaceView(long id, String title, Collection<GameCard> games) {
        this.id = id;
        this.title = title;
        this.games = games;
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

    public Collection<GameCard> getGames() {
        return games;
    }

    public void setGames(Collection<GameCard> games) {
        this.games = games;
    }
}
