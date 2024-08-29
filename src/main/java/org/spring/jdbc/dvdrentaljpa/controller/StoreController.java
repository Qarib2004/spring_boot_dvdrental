package org.spring.jdbc.dvdrentaljpa.controller;

import org.spring.jdbc.dvdrentaljpa.entity.Store;
import org.spring.jdbc.dvdrentaljpa.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/stores")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @GetMapping
    public String listStores(Model model) {
        List<Store> stores = storeService.getAllStores();
        model.addAttribute("stores", stores);
        return "stores/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("store", new Store());
        return "stores/form";
    }

    @PostMapping("/create")
    public String createStore(@ModelAttribute Store store) {
        storeService.insert(store);
        return "redirect:/stores";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Optional<Store> store = storeService.getStoreById(id);
        if (store.isPresent()) {
            model.addAttribute("store", store.get());
            return "stores/form";
        } else {
            return "redirect:/stores";
        }
    }

    @PostMapping("/update/{id}")
    public String updateStore(@PathVariable int id, @ModelAttribute Store store) {
        store.setStore_id(id);
        storeService.update(store);
        return "redirect:/stores";
    }

    @GetMapping("/delete/{id}")
    public String deleteStore(@PathVariable int id) {
        storeService.delete(id);
        return "redirect:/stores";
    }

    @GetMapping("/{id}")
    public String showStoreDetails(@PathVariable int id, Model model) {
        Optional<Store> store = storeService.getStoreById(id);
        if (store.isPresent()) {
            model.addAttribute("store", store.get());
            return "stores/details";
        } else {
            return "redirect:/stores";
        }
    }
}
