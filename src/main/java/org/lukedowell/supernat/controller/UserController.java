package org.lukedowell.supernat.controller;

import org.lukedowell.supernat.domain.Response;
import org.lukedowell.supernat.services.JwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by ldowell on 11/23/15.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @RequestMapping(method = RequestMethod.GET, value = "/info")
    public Response<Principal> getUserData(Principal principal) {
        return new Response<>(principal);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public Response<String> login(@RequestBody final UserLogin login) {
        logger.debug("login - login: {}", login);
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(login.name, login.password);
        authenticationManager.authenticate(token);

        return new Response<>(jwtService.generateToken(login.name));
    }

    private static class UserLogin {
        public String name;
        public String password;
    }
}
