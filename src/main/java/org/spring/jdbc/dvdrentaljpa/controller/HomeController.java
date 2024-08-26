package org.spring.jdbc.dvdrentaljpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home"; // Имя шаблона, например home.html в src/main/resources/templates
    }
}