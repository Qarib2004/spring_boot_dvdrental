package org.spring.jdbc.dvdrentaljpa.controller;

import org.spring.jdbc.dvdrentaljpa.entity.Address;
import org.spring.jdbc.dvdrentaljpa.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping
    public String getAllAddresses(Model model) {
        List<Address> addresses = addressService.getAllAddresses();
        model.addAttribute("addresses", addresses);
        return "addresses/address-list";  // Убедитесь, что файл address-list.html существует в папке templates/addresses
    }

    @GetMapping("/{id}")
    public String getAddressById(@PathVariable int id, Model model) {
        Optional<Address> address = addressService.getAddressById(id);
        if (address.isPresent()) {
            model.addAttribute("address", address.get());
            return "addresses/address-detail";  // Убедитесь, что файл address-detail.html существует в папке templates/addresses
        } else {
            return "error/404";  // Убедитесь, что у вас есть 404.html для обработки отсутствующих ресурсов
        }
    }

    @GetMapping("/add")
    public String showAddAddressForm(Model model) {
        model.addAttribute("address", new Address());
        return "addresses/address-form";  // Убедитесь, что файл address-form.html существует в папке templates/addresses
    }

    @PostMapping("/add")
    public String addAddress(@ModelAttribute Address address) {
        addressService.insert(address);
        return "redirect:/addresses";
    }

    @GetMapping("/edit/{id}")
    public String showEditAddressForm(@PathVariable int id, Model model) {
        Optional<Address> address = addressService.getAddressById(id);
        if (address.isPresent()) {
            model.addAttribute("address", address.get());
            return "addresses/address-form";  // Убедитесь, что файл address-form.html существует в папке templates/addresses
        } else {
            return "error/404";
        }
    }

    @PostMapping("/edit/{id}")
    public String editAddress(@PathVariable int id, @ModelAttribute Address address) {
        address.setAddressId(id);
        addressService.update(address);
        return "redirect:/addresses";
    }

    @GetMapping("/delete/{id}")
    public String deleteAddress(@PathVariable int id) {
        addressService.delete(id);
        return "redirect:/addresses";
    }
}

