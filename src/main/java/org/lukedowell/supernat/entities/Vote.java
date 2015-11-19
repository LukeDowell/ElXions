package org.lukedowell.supernat.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 *
 * A single vote. A systemUser may create a vote for a given game
 * and electoral period.
 *
 * Created by ldowell on 11/19/15.
 */
@Entity
public class Vote {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;

    @ManyToOne
    private Game game;

    @OneToMany
    private SystemUser systemUser;

    @ManyToMany
    private Race race;
}
