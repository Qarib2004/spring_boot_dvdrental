package org.spring.jdbc.dvdrentaljpa.controller;


import org.spring.jdbc.dvdrentaljpa.entity.Actor;
import org.spring.jdbc.dvdrentaljpa.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @Controller
    @RequestMapping("/actors")
    public class ActorController {

        @Autowired
        private ActorService actorService;

        @GetMapping
        public String getAllActors(Model model) {
            List<Actor> actors = actorService.getAllActors();
            model.addAttribute("actors", actors);
            return "actors/actor-list";  // Убедитесь, что файл actor-list.html существует в папке templates/actors
        }

        @GetMapping("/{id}")
        public String getActorById(@PathVariable int id, Model model) {
            Actor actor = actorService.getActorById(id);
            model.addAttribute("actor", actor);
            return "actors/actor-detail";  // Убедитесь, что файл actor-detail.html существует в папке templates/actors
        }

        @GetMapping("/add")
        public String showAddActorForm(Model model) {
            model.addAttribute("actor", new Actor());
            return "actors/actor-form";
        }

        @PostMapping("/add")
        public String addActor(@ModelAttribute Actor actor) {
            actorService.insert(actor);
            return "redirect:/actors";
        }

        @GetMapping("/edit/{id}")
        public String showEditActorForm(@PathVariable int id, Model model) {
            Actor actor = actorService.getActorById(id);
            model.addAttribute("actor", actor);
            return "actors/actor-form";
        }

        @PostMapping("/edit/{id}")
        public String editActor(@PathVariable int id, @ModelAttribute Actor actor) {
            actor.setActorId(id);
            actorService.update(actor);
            return "redirect:/actors";
        }

        @GetMapping("/delete/{id}")
        public String deleteActor(@PathVariable int id) {
            actorService.delete(id);
            return "redirect:/actors";
        }
    }

