package com.codecool.clinic.authentication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class ViewController {

    @RequestMapping("/welcome")
    public String welcome(Map<String, Object> model) {
        model.put("message", "Hey Weronika");
        return "welcome";
    }

}
