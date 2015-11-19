package org.lukedowell.supernat.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 *
 * A representation of a game. Games can be created and voted
 * on by users. Games can only belong to a single genre for
 * simplicity's sake.
 *
 * Created by ldowell on 11/19/15.
 */
@Entity
public class Game {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;

    private String title;

    @ManyToOne
    private Genre genre;

    private Date createdOn;

    private boolean isOwned;
}
