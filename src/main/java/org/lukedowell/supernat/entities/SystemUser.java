package org.lukedowell.supernat.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ldowell on 11/23/15.
 */
@Entity
public class SystemUser {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long userId;

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    private Collection<String> roles;

    @OneToMany(mappedBy = "user", targetEntity = ParticipationRecord.class)
    private Collection<ParticipationRecord> records;

    private String username;

    private String password;

    public SystemUser() {}

    public SystemUser(String username, String password, Collection roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<String> getRoles() {
        return roles;
    }

    public void setRoles(Collection<String> roles) {
        this.roles = roles;
    }

}
