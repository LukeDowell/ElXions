package org.lukedowell.supernat.entities;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

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

    @OneToMany
    private Collection<Vote> votes;

    private String name;

    private String password;

    public SystemUser() {}

    public SystemUser(String username, String password) {
        this.name = username;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
