package org.lukedowell.supernat.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * An Election is the wrapper that contains a bunch of races. An election has
 * an end date which usually is the end of the month.
 *
 * Created by ldowell on 11/19/15.
 */
@Entity
public class Election {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;

    private Date endDate;
}
