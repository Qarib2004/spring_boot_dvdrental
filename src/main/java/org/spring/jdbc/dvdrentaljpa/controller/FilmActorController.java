package org.spring.jdbc.dvdrentaljpa.controller;

import org.spring.jdbc.dvdrentaljpa.entity.Actor;
import org.spring.jdbc.dvdrentaljpa.entity.Film;
import org.spring.jdbc.dvdrentaljpa.entity.FilmActor;
import org.spring.jdbc.dvdrentaljpa.service.ActorService;
import org.spring.jdbc.dvdrentaljpa.service.FilmActorService;
import org.spring.jdbc.dvdrentaljpa.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Controller
@RequestMapping("/filmActors")
public class FilmActorController {

    private static final Logger logger = Logger.getLogger(FilmActorController.class.getName());

    @Autowired
    private FilmActorService filmActorService;

    @GetMapping
    public String getAllFilmActors(Model model) {
        logger.info("Getting all film actors");
        List<FilmActor> filmActors = filmActorService.getAllFilmActors();
        model.addAttribute("filmActors", filmActors);
        return "filmActors/film-actors"; // путь к HTML-файлу внутри папки filmActors
    }

    @GetMapping("/{id}")
    public String getFilmActorById(@PathVariable("id") int id, Model model) {
        logger.info("Getting film actor with ID: " + id);
        Optional<FilmActor> filmActor = filmActorService.getFilmActorById(id);
        if (filmActor.isPresent()) {
            model.addAttribute("filmActor", filmActor.get());
            return "filmActors/film-actor-detail"; // путь к HTML-файлу для детальной информации
        } else {
            model.addAttribute("error", "Film Actor not found");
            return "filmActors/error"; // путь к HTML-файлу для ошибок
        }
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("filmActor", new FilmActor());
        return "filmActors/film-actor-form"; // путь к форме для создания нового FilmActor
    }

    @PostMapping
    public String createFilmActor(@ModelAttribute("filmActor") FilmActor filmActor) {
        logger.info("Creating new film actor");
        filmActorService.insert(filmActor);
        return "redirect:/filmActors";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Optional<FilmActor> filmActor = filmActorService.getFilmActorById(id);
        if (filmActor.isPresent()) {
            model.addAttribute("filmActor", filmActor.get());
            return "filmActors/film-actor-form"; // путь к форме для редактирования FilmActor
        } else {
            model.addAttribute("error", "Film Actor not found");
            return "filmActors/error";
        }
    }

    @PostMapping("/update/{id}")
    public String updateFilmActor(@PathVariable("id") int id, @ModelAttribute("filmActor") FilmActor filmActor) {
        logger.info("Updating film actor with ID: " + id);
        filmActorService.update(filmActor);
        return "redirect:/filmActors";
    }

    @GetMapping("/delete/{id}")
    public String deleteFilmActor(@PathVariable("id") int id) {
        logger.info("Deleting film actor with ID: " + id);
        filmActorService.delete(id);
        return "redirect:/filmActors";
    }
}