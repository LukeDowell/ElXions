package org.lukedowell.supernat.config;

import org.lukedowell.supernat.entities.SystemUser;
import org.lukedowell.supernat.filter.JwtFilter;
import org.lukedowell.supernat.repositories.SystemUserRepository;
import org.lukedowell.supernat.services.JwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by ldowell on 11/20/15.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(WebSecurityConfig.class);

    @Autowired
    SystemUserRepository systemUserRepository;

    @Autowired
    JwtService jwtService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable() //TODO: enable
                .exceptionHandling().and()
                .anonymous().and()
                .servletApi().and()
                .headers().cacheControl().and().and()
                .authorizeRequests()
                    .antMatchers("/").permitAll()
                    .antMatchers("/**/*.css").permitAll()
                    .antMatchers("/**/*.js").permitAll()
                    .antMatchers("/api/v1/login").permitAll()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/home")
                    .permitAll()
                    .and()
                .logout()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/login")
                    .permitAll()
                    .and()

                .addFilterBefore(new JwtFilter(jwtService), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        return (username) -> {

            SystemUser user = systemUserRepository.findByUsername(username);
            logger.debug("userDetailsService - authenticating user: {}", user);

            if(user != null) {
                return user;
            } else {
                logger.debug("userDetailsService - Failed to authenticate user: {}", user);
                throw new UsernameNotFoundException("The user with username: " + username + " cannot be found.");
            }
        };
    }
}