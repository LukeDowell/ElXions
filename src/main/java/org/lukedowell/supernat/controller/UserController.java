package org.lukedowell.supernat.controller;

import org.lukedowell.supernat.domain.Response;
import org.springframework.security.access.annotation.Secured;
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

    @RequestMapping(method = RequestMethod.GET, value = "/info")
    public Response<Principal> getUserData(Principal principal) {
        return new Response<>(principal);
    }
}
