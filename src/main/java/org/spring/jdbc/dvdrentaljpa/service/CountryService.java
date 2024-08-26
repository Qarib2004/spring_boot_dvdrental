package org.spring.jdbc.dvdrentaljpa.service;

import org.spring.jdbc.dvdrentaljpa.entity.Country;
import org.spring.jdbc.dvdrentaljpa.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class CountryService {

    private static final Logger logger = Logger.getLogger(CountryService.class.getName());

    @Autowired
    private CountryRepository countryRepository;


    public void insert(Country country){
        logger.info("Insert country: " + country);
        countryRepository.save(country);
    }

    public void update(Country country_id){
        logger.info("Update country by id: " + country_id);
        countryRepository.save(country_id);
    }

    public void delete(int country_id){
        logger.info("Delete country by id: " + country_id);
        countryRepository.deleteById(country_id);
    }

    public List<Country> getAllCountries() {
        logger.info("Select all table: country");
        return countryRepository.findAll();
    }

    public Optional<Country> getCountryById(int country_id) {
        logger.info("Select country by id: " + country_id);
        return countryRepository.findById(country_id);
    }
}

