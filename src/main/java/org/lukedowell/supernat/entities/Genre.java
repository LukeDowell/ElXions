package org.lukedowell.supernat.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * A representation of a genre. Genres provide the relational link
 * between races and games.
 *
 * Created by ldowell on 11/19/15.
 */
@Entity
public class Genre {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;

    private String name;

}
