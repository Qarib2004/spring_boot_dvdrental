package org.spring.jdbc.dvdrentaljpa.repository;

import org.spring.jdbc.dvdrentaljpa.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental,Integer> {
}
