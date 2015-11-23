package org.lukedowell.supernat.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by ldowell on 11/19/15.
 */
@Controller
public class WebController {

    @Value("${application.title}")
    private String title;

    @RequestMapping("/home")
    @Secured({"ROLE_VOTER", "ROLE_ADMIN"})
    public String home(Model model) {
        return "home";
    }

    @RequestMapping("/")
    public String index(Map<String, Object> model) {
        model.put("title", this.title);
        return "login";
    }


}

