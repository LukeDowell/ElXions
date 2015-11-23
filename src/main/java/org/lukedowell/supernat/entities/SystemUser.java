package org.lukedowell.supernat.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.javafx.font.freetype.FTFactory;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ldowell on 11/23/15.
 */
@Entity
public class SystemUser extends User implements UserDetails {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long userId;

    @ManyToMany(mappedBy = "participants", targetEntity = Race.class, fetch = FetchType.EAGER)
    private Collection races;

    public SystemUser(String username, String password) {
        this(username, password, AuthorityUtils.createAuthorityList("VOTER"));
    }

    public SystemUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }
}
