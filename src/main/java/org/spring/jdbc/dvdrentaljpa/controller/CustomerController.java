package org.spring.jdbc.dvdrentaljpa.controller;

import org.spring.jdbc.dvdrentaljpa.entity.Customer;
import org.spring.jdbc.dvdrentaljpa.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private static final Logger logger = Logger.getLogger(CustomerController.class.getName());

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public String listCustomers(Model model) {
        logger.info("Fetching all customers");
        List<Customer> customers = customerService.getAllCustomers();
        model.addAttribute("customers", customers);
        return "customers/list-customers";
    }

//    @GetMapping("/showFormForAdd")
//    public String showFormForAdd(Model model) {
//        Customer customer = new Customer();
//        model.addAttribute("customer", customer);
//        return "customers/customer-form";
//    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable("id") int id, Model model) {
        Optional<Customer> customerOpt = customerService.getCustomerById(id);
        if (customerOpt.isPresent()) {
            model.addAttribute("customer", customerOpt.get());
            return "customers/customer-form";
        } else {
            return "redirect:/customers";
        }
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "customers/customer-form";
    }

    @GetMapping("/{id}")
    public String getCustomerDetails(@PathVariable("id") int id, Model model) {
        Optional<Customer> customerOpt = customerService.getCustomerById(id);
        if (customerOpt.isPresent()) {
            model.addAttribute("customer", customerOpt.get());
            return "customers/customer-detail";
        } else {
            return "redirect:/customers";
        }
    }

    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        logger.info("Saving customer: " + customer);
        customerService.insert(customer); // Этот метод в вашем сервисе сохраняет и для добавления, и для обновления
        return "redirect:/customers";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable("id") int id) {
        logger.info("Deleting customer with ID: " + id);
        customerService.delete(id);
        return "redirect:/customers";
    }
}


