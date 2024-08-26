package org.spring.jdbc.dvdrentaljpa.service;

import org.spring.jdbc.dvdrentaljpa.entity.Rental;
import org.spring.jdbc.dvdrentaljpa.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class RentalService {

    private static final Logger logger = Logger.getLogger(RentalService.class.getName());

    @Autowired
    private RentalRepository rentalRepository;

    public void insert(Rental rental) {
        logger.info("Insert rental: " + rental);
        rentalRepository.save(rental);
    }

    public void update(Rental rentalId) {
        logger.info("Update rental by id: " + rentalId);
        rentalRepository.save(rentalId);
    }

    public void delete(int rentalId) {
        logger.info("Delete rental by id: " + rentalId);
        rentalRepository.deleteById(rentalId);
    }

    public List<Rental> getAllRentals() {
        logger.info("Select all table: rental");
        return rentalRepository.findAll();
    }

    public Optional<Rental> getRentalById(int rentalId) {
        logger.info("Select rental by id: " + rentalId);
        return rentalRepository.findById(rentalId);
    }
}

