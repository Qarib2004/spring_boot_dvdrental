package org.spring.jdbc.dvdrentaljpa.controller;

import org.spring.jdbc.dvdrentaljpa.entity.Country;
import org.spring.jdbc.dvdrentaljpa.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping
    public String getAllCountries(Model model) {
        List<Country> countries = countryService.getAllCountries();
        model.addAttribute("countries", countries);
        return "countries/country-list";
    }

    @GetMapping("/{id}")
    public String getCountryById(@PathVariable int id, Model model) {
        Country country = countryService.getCountryById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid country Id:" + id));
        model.addAttribute("country", country);
        return "countries/country-detail";
    }

    @GetMapping("/add")
    public String showAddCountryForm(Model model) {
        model.addAttribute("country", new Country());
        return "countries/country-form";
    }

    @PostMapping("/add")
    public String addCountry(@ModelAttribute Country country) {
        countryService.insert(country);
        return "redirect:/countries";
    }

    @GetMapping("/edit/{id}")
    public String showEditCountryForm(@PathVariable int id, Model model) {
        Country country = countryService.getCountryById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid country Id:" + id));
        model.addAttribute("country", country);
        return "countries/country-form";
    }

    @PostMapping("/edit/{id}")
    public String editCountry(@PathVariable int id, @ModelAttribute Country country) {
        country.setCountry_id(id);
        countryService.update(country);
        return "redirect:/countries";
    }

    @GetMapping("/delete/{id}")
    public String deleteCountry(@PathVariable int id) {
        countryService.delete(id);
        return "redirect:/countries";
    }
}
