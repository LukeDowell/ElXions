package org.lukedowell.supernat.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 *
 * A race attaches itself to an election period and a genre. Many games
 * can be voted on in the race as long as they share the same genre. A
 * race ends at the same time as an election.
 *
 * Created by ldowell on 11/19/15.
 */
@Entity
public class Race {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;

    @ManyToOne
    private Election election;

    @ManyToOne
    private Genre genre;
}
