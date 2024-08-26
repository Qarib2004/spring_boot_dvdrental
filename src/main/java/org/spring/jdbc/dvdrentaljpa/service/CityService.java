package org.spring.jdbc.dvdrentaljpa.service;

import org.spring.jdbc.dvdrentaljpa.entity.City;
import org.spring.jdbc.dvdrentaljpa.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class CityService {

    private static final Logger logger = Logger.getLogger(CityService.class.getName());

    @Autowired
    private CityRepository cityRepository;

    public void insert(City city){
        logger.info("Insert city: " + city);
        cityRepository.save(city);
    }

    public void update(City city_id){
        logger.info("Update city by id: " + city_id);
        City city = new City();
        cityRepository.save(city_id);
    }

    public void delete(int city_id){
        logger.info("Delete city by id: " + city_id);
        cityRepository.deleteById(city_id);
    }

    public List<City> getAllCities() {
        logger.info("Select all table: city");
        return cityRepository.findAll();
    }

    public Optional<City> getCityById(int city_id) {
        logger.info("Select city by id: " + city_id);
        return cityRepository.findById(city_id);
    }
}

