package org.spring.jdbc.dvdrentaljpa.controller;

import org.spring.jdbc.dvdrentaljpa.entity.Staff;
import org.spring.jdbc.dvdrentaljpa.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/staffs")
public class StaffController {
    @Autowired
    StaffService staffService;

    @GetMapping
    public String listStaffs(Model model){
        List<Staff> staffs = staffService.getAllStaff();
        model.addAttribute("staffs",staffs);
        return "staffs/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("staff",new Staff());
        return "staffs/form";
    }

    @PostMapping("/create")
    public String createStaff(@ModelAttribute Staff staff){
        staffService.insert(staff);
        return "redirect:/staffs";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id,Model model){
        Optional<Staff> staff = staffService.getStaffById(id);
        if(staff.isPresent()){
            model.addAttribute("staff",staff.get());
            return "staffs/form";
        }else {
            return "redirect:/staffs";
        }
    }

    @PostMapping("/update/{id}")
    public String updateStuff(@PathVariable int id,@ModelAttribute Staff staff){
        staff.setStaff_id(id);
        staffService.update(staff);
        return "redirect:/staffs";
    }

    @GetMapping("/delete/{id}")
    public String deleteStaff(@PathVariable int id){
        staffService.delete(id);
        return "redirect:/staffs";
    }

    @GetMapping("/{id}")
    public String showStaffDetails(@PathVariable int id,Model model){
        Optional<Staff> staff = staffService.getStaffById(id);
        if(staff.isPresent()){
            model.addAttribute("staff",staff.get());
            return "staffs/details";
        }else {
            return "redirect:/stuffs";
        }
    }
}
