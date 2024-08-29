package org.spring.jdbc.dvdrentaljpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("tablesLink", "/tables"); // Ссылка на страницу со списком таблиц
        return "home"; // Имя шаблона, например home.html в src/main/resources/templates
    }
}
