package org.spring.jdbc.dvdrentaljpa.controller;

import org.spring.jdbc.dvdrentaljpa.entity.Inventory;
import org.spring.jdbc.dvdrentaljpa.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/inventories")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping
    public String listInventories(Model model) {
        List<Inventory> inventories = inventoryService.getAllInventories();
        model.addAttribute("inventories", inventories);
        return "inventories/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("inventory", new Inventory());
        return "inventories/form";
    }

    @PostMapping("/create")
    public String createInventory(@ModelAttribute Inventory inventory) {
        inventoryService.insert(inventory);
        return "redirect:/inventories";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Optional<Inventory> inventory = inventoryService.getInventoryById(id);
        if (inventory.isPresent()) {
            model.addAttribute("inventory", inventory.get());
            return "inventories/form";
        } else {
            return "redirect:/inventories";
        }
    }

    @PostMapping("/update/{id}")
    public String updateInventory(@PathVariable int id, @ModelAttribute Inventory inventory) {
        inventory.setInventory_id(id);
        inventoryService.update(inventory);
        return "redirect:/inventories";
    }

    @GetMapping("/delete/{id}")
    public String deleteInventory(@PathVariable int id) {
        inventoryService.delete(id);
        return "redirect:/inventories";
    }

    @GetMapping("/{id}")
    public String showInventoryDetails(@PathVariable int id, Model model) {
        Optional<Inventory> inventory = inventoryService.getInventoryById(id);
        if (inventory.isPresent()) {
            model.addAttribute("inventory", inventory.get());
            return "inventories/details";
        } else {
            return "redirect:/inventories";
        }
    }
}
