package org.spring.jdbc.dvdrentaljpa.service;

import org.spring.jdbc.dvdrentaljpa.entity.Payment;
import org.spring.jdbc.dvdrentaljpa.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class PaymentService {
    private static final Logger logger = Logger.getLogger(PaymentService.class.getName());

    @Autowired
    private PaymentRepository paymentRepository;

    public void insert(Payment payment) {
        logger.info("Insert payment: " + payment);
        paymentRepository.save(payment);
    }

    public void update(Payment paymentId) {
        logger.info("Update payment by id: " + paymentId);
        paymentRepository.save(paymentId);
    }

    public void delete(int paymentId) {
        logger.info("Delete payment by id: " + paymentId);
        paymentRepository.deleteById(paymentId);
    }

    public List<Payment> getAllPayments() {
        logger.info("Select all table: payment");
        return paymentRepository.findAll();
    }

    public Optional<Payment> getPaymentById(int paymentId) {
        logger.info("Select payment by id: " + paymentId);
        return paymentRepository.findById(paymentId);
    }
}

