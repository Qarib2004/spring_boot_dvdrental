package org.spring.jdbc.dvdrentaljpa.controller;

import org.spring.jdbc.dvdrentaljpa.entity.Payment;
import org.spring.jdbc.dvdrentaljpa.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public String listPayments(Model model) {
        List<Payment> payments = paymentService.getAllPayments();
        model.addAttribute("payments", payments);
        return "payments/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("payment", new Payment());
        return "payments/form";
    }

    @PostMapping("/create")
    public String createPayment(@ModelAttribute Payment payment) {
        paymentService.insert(payment);
        return "redirect:/payments";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Optional<Payment> payment = paymentService.getPaymentById(id);
        if (payment.isPresent()) {
            model.addAttribute("payment", payment.get());
            return "payments/form";
        } else {
            return "redirect:/payments";
        }
    }

    @PostMapping("/update/{id}")
    public String updatePayment(@PathVariable int id, @ModelAttribute Payment payment) {
        payment.setPayment_id(id);
        paymentService.update(payment);
        return "redirect:/payments";
    }

    @GetMapping("/delete/{id}")
    public String deletePayment(@PathVariable int id) {
        paymentService.delete(id);
        return "redirect:/payments";
    }

    @GetMapping("/{id}")
    public String showPaymentDetails(@PathVariable int id, Model model) {
        Optional<Payment> payment = paymentService.getPaymentById(id);
        if (payment.isPresent()) {
            model.addAttribute("payment", payment.get());
            return "payments/details";
        } else {
            return "redirect:/payments";
        }
    }
}
