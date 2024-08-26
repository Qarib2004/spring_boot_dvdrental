package org.spring.jdbc.dvdrentaljpa.controller;

import org.spring.jdbc.dvdrentaljpa.entity.Category;
import org.spring.jdbc.dvdrentaljpa.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String getAllCategories(Model model) {
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "categories/list";
    }

    @GetMapping("/{id}")
    public String getCategoryById(@PathVariable("id") int id, Model model) {
        Category category = categoryService.getCategoryById(id).orElse(null);
        model.addAttribute("category", category);
        return "categories/detail";
    }

    @GetMapping("/new")
    public String showNewCategoryForm(Model model) {
        model.addAttribute("category", new Category());
        return "categories/new";
    }

    @PostMapping
    public String createCategory(@ModelAttribute("category") Category category) {
        categoryService.insert(category);
        return "redirect:/categories";
    }

    @GetMapping("/{id}/edit")
    public String showEditCategoryForm(@PathVariable("id") int id, Model model) {
        Category category = categoryService.getCategoryById(id).orElse(null);
        model.addAttribute("category", category);
        return "categories/edit";
    }

    @PostMapping("/{id}")
    public String updateCategory(@PathVariable("id") int id, @ModelAttribute("category") Category category) {
        category.setCategory_id(id);
        categoryService.update(category);
        return "redirect:/categories";
    }

    @PostMapping("/{id}/delete")
    public String deleteCategory(@PathVariable("id") int id) {
        categoryService.delete(id);
        return "redirect:/categories";
    }
}