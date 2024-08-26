package org.spring.jdbc.dvdrentaljpa.repository;

import org.spring.jdbc.dvdrentaljpa.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {
}
