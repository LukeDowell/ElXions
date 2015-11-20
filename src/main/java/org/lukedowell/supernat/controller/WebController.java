package org.lukedowell.supernat.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
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
    public String home(Map<String, Object> model) {
        return "secured";
    }

    @RequestMapping("/")
    public String index(Map<String, Object> model) {
        model.put("title", this.title);
        return "login";
    }


}
