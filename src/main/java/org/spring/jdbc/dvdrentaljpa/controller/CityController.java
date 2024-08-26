package org.spring.jdbc.dvdrentaljpa.controller;

import org.spring.jdbc.dvdrentaljpa.entity.City;
import org.spring.jdbc.dvdrentaljpa.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping
    public String getAllCities(Model model) {
        model.addAttribute("cities", cityService.getAllCities());
        return "cities/cities";
    }

    @GetMapping("/{id}")
    public String getCityById(@PathVariable("id") int id, Model model) {
        Optional<City> city = cityService.getCityById(id);
        if (city.isPresent()) {
            model.addAttribute("city", city.get());
            return "cities/city-detail";
        } else {
            return "error";
        }
    }

    @GetMapping("/create")
    public String createCityForm(Model model) {
        model.addAttribute("city", new City());
        return "cities/city-form";
    }

    @PostMapping("/create")
    public String createCity(@ModelAttribute City city) {
        cityService.insert(city);
        return "redirect:/cities";
    }

    @GetMapping("/update/{id}")
    public String updateCityForm(@PathVariable("id") int id, Model model) {
        Optional<City> city = cityService.getCityById(id);
        if (city.isPresent()) {
            model.addAttribute("city", city.get());
            return "cities/city-form";
        } else {
            return "error";
        }
    }

    @PostMapping("/update")
    public String updateCity(@ModelAttribute City city) {
        cityService.update(city);
        return "redirect:/cities";
    }

    @GetMapping("/delete/{id}")
    public String deleteCity(@PathVariable("id") int id) {
        cityService.delete(id);
        return "redirect:/cities";
    }
}
