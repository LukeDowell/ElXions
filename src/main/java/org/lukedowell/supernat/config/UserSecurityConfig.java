package org.lukedowell.supernat.config;

import org.lukedowell.supernat.entities.SystemUser;
import org.lukedowell.supernat.repositories.SystemUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by ldowell on 11/20/15.
 */
@Configuration
public class UserSecurityConfig extends GlobalAuthenticationConfigurerAdapter {

    @Autowired
    SystemUserRepository systemUserRepository;


    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }

    @Bean
    UserDetailsService userDetailsService() {
        return (username) -> {
            SystemUser user = systemUserRepository.findSystemUserByName(username);
            if(user != null) {
                return new User(user.getName(), user.getPassword(), AuthorityUtils.createAuthorityList("ROLE_USER"));
            } else {
                throw new UsernameNotFoundException("Could not find user: " + username);
            }
        };
    }
}
