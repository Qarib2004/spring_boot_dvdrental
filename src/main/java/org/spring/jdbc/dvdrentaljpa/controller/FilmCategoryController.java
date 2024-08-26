package org.spring.jdbc.dvdrentaljpa.controller;


import org.spring.jdbc.dvdrentaljpa.entity.FilmCategory;
import org.spring.jdbc.dvdrentaljpa.service.FilmCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/filmCategories")
public class FilmCategoryController {

    @Autowired
    private FilmCategoryService filmCategoryService;

    @GetMapping
    public String listFilmCategories(Model model) {
        List<FilmCategory> filmCategories = filmCategoryService.getAllFilmCategories();
        model.addAttribute("filmCategories", filmCategories);
        return "filmCategories/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("filmCategory", new FilmCategory());
        return "filmCategories/form";
    }

    @PostMapping("/create")
    public String createFilmCategory(@ModelAttribute FilmCategory filmCategory) {
        filmCategoryService.insert(filmCategory);
        return "redirect:/filmCategories";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Optional<FilmCategory> filmCategory = filmCategoryService.getFilmCategoryById(id);
        if (filmCategory.isPresent()) {
            model.addAttribute("filmCategory", filmCategory.get());
            return "filmCategories/form";
        } else {
            return "redirect:/filmCategories";
        }
    }

    @PostMapping("/update/{id}")
    public String updateFilmCategory(@PathVariable int id, @ModelAttribute FilmCategory filmCategory) {
        filmCategory.setFilmCategoryId(id);
        filmCategoryService.update(filmCategory);
        return "redirect:/filmCategories";
    }

    @GetMapping("/delete/{id}")
    public String deleteFilmCategory(@PathVariable int id) {
        filmCategoryService.delete(id);
        return "redirect:/filmCategories";
    }

    @GetMapping("/{id}")
    public String showFilmCategoryDetails(@PathVariable int id, Model model) {
        Optional<FilmCategory> filmCategory = filmCategoryService.getFilmCategoryById(id);
        if (filmCategory.isPresent()) {
            model.addAttribute("filmCategory", filmCategory.get());
            return "filmCategories/details";
        } else {
            return "redirect:/filmCategories";
        }
    }
}
