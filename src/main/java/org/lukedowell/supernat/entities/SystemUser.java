package org.lukedowell.supernat.entities;

import org.hibernate.annotations.GenericGenerator;
import sun.security.util.Password;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * A user of the election system. Can vote and create
 * new games.
 *
 * Created by ldowell on 11/19/15.
 */
@Entity
public class SystemUser {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;

    private String name;

    private Password password;

//    private String salt;
}
