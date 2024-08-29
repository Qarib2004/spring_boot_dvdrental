package org.spring.jdbc.dvdrentaljpa.controller;

import ch.qos.logback.core.read.ListAppender;
import org.spring.jdbc.dvdrentaljpa.entity.Payment;
import org.spring.jdbc.dvdrentaljpa.entity.Rental;
import org.spring.jdbc.dvdrentaljpa.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/rentals")
public class RentalController {
    @Autowired
    RentalService rentalService;

    @GetMapping
    public String listRentals(Model model){
        List<Rental> rentals = rentalService.getAllRentals();
        model.addAttribute("rentals",rentals);
        return "rentals/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("payment",new Rental());
        return "rentals/form";
    }


    @PostMapping("/create")
    public String createRental(@ModelAttribute Rental rental){
        rentalService.insert(rental);
        return "redirect:/rentals";
    }


    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id,Model model){
        Optional<Rental> rental = rentalService.getRentalById(id);
        if(rental.isPresent()){
            model.addAttribute("rental",rental.get());
            return "rentals/form";
        }else{
            return "redirect:/rentals";
        }
    }


    @PostMapping("/update/{id}")
    public String updateRental(@PathVariable int id,@ModelAttribute Rental rental){
        rental.setRental_id(id);
        rentalService.update(rental);
        return "redirect:/rentals";
    }



    @GetMapping("/delete/{id}")
    public String deleteRental(@PathVariable int id){
        rentalService.delete(id);
        return "redirect:/rentals";
    }

    @GetMapping("/{id}")
    public String showRentalDetails(@PathVariable int id,Model model){
        Optional<Rental> rental = rentalService.getRentalById(id);
        if(rental.isPresent()){
            model.addAttribute("rental",rental.get());
            return "payments/details";
        } else {
            return "redirect:/payments";
        }
    }

}
