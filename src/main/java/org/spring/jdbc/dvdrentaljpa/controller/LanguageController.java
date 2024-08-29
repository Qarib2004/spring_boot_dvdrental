package org.spring.jdbc.dvdrentaljpa.controller;

import org.spring.jdbc.dvdrentaljpa.entity.Language;
import org.spring.jdbc.dvdrentaljpa.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/languages")
public class LanguageController {

    @Autowired
    private LanguageService languageService;

    @GetMapping
    public String listLanguages(Model model) {
        List<Language> languages = languageService.getAllLanguages();
        model.addAttribute("languages", languages);
        return "languages/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("language", new Language());
        return "languages/form";
    }

    @PostMapping("/create")
    public String createLanguage(@ModelAttribute Language language) {
        languageService.insert(language);
        return "redirect:/languages";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Optional<Language> language = languageService.getLanguageById(id);
        if (language.isPresent()) {
            model.addAttribute("language", language.get());
            return "languages/form";
        } else {
            return "redirect:/languages";
        }
    }

    @PostMapping("/update/{id}")
    public String updateLanguage(@PathVariable int id, @ModelAttribute Language language) {
        language.setLanguage_id(id);
        languageService.update(language);
        return "redirect:/languages";
    }

    @GetMapping("/delete/{id}")
    public String deleteLanguage(@PathVariable int id) {
        languageService.delete(id);
        return "redirect:/languages";
    }

    @GetMapping("/{id}")
    public String showLanguageDetails(@PathVariable int id, Model model) {
        Optional<Language> language = languageService.getLanguageById(id);
        if (language.isPresent()) {
            model.addAttribute("language", language.get());
            return "languages/details";
        } else {
            return "redirect:/languages";
        }
    }
}
