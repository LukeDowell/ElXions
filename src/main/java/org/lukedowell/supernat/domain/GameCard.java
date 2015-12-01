package org.lukedowell.supernat.domain;

import org.lukedowell.supernat.entities.Game;
import org.lukedowell.supernat.entities.GameEntry;

/**
 *
 * A view model representation of a game card. The card is most often displayed
 * on the vote page
 * Created by ldowell on 11/25/15.
 */
public class GameCard {

    private long id;

    private String title;

    private long numVotes;

    public GameCard() {}

    public GameCard(GameEntry gameEntry) {
        Game game = gameEntry.getGame();

        this.id = gameEntry.getGameEntryId();
        this.title = game.getTitle();
        this.numVotes = gameEntry.getVotes().size();
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

    public long getNumVotes() {
        return numVotes;
    }

    public void setNumVotes(int numVotes) {
        this.numVotes = numVotes;
    }

    @Override
    public String toString() {
        return String.format("%d -- Title: %s -- Votes: %d", this.getId(), this.getTitle(), this.getNumVotes());
    }
}
