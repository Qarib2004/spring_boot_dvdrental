package org.spring.jdbc.dvdrentaljpa.controller;

import org.spring.jdbc.dvdrentaljpa.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TableController {

    @Autowired
    private TableService tableService;

    @GetMapping("/tables")
    public String listTables(Model model) {
        List<String> tables = tableService.getAllTables();
        model.addAttribute("tables", tables);
        return "tables"; // Имя шаблона для отображения списка таблиц
    }
}
