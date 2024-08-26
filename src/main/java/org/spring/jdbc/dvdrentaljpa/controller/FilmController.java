package org.spring.jdbc.dvdrentaljpa.controller;

import org.spring.jdbc.dvdrentaljpa.entity.Film;
import org.spring.jdbc.dvdrentaljpa.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Controller
@RequestMapping("/films")
public class FilmController {

    private static final Logger logger = Logger.getLogger(FilmController.class.getName());

    @Autowired
    private FilmService filmService;

    @GetMapping
    public String listFilms(Model model) {
        logger.info("Fetching all films");
        List<Film> films = filmService.getAllFilms();
        model.addAttribute("films", films);
        return "films/list-films";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Film film = new Film();
        model.addAttribute("film", film);
        return "films/film-form";
    }

    @PostMapping("/save")
    public String saveFilm(@ModelAttribute("film") Film film) {
        logger.info("Saving film: " + film);
        filmService.insert(film);
        return "redirect:/films";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable("id") int id, Model model) {
        Optional<Film> filmOpt = filmService.getFilmById(id);
        if (filmOpt.isPresent()) {
            model.addAttribute("film", filmOpt.get());
            return "films/film-form";
        } else {
            return "redirect:/films";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteFilm(@PathVariable("id") int id) {
        logger.info("Deleting film with ID: " + id);
        filmService.delete(id);
        return "redirect:/films";
    }

    @GetMapping("/{id}")
    public String getFilmDetails(@PathVariable("id") int id, Model model) {
        Optional<Film> filmOpt = filmService.getFilmById(id);
        if (filmOpt.isPresent()) {
            model.addAttribute("film", filmOpt.get());
            return "films/film-detail";
        } else {
            return "redirect:/films";
        }
    }
}

