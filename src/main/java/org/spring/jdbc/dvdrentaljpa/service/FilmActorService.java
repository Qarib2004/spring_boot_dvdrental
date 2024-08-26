package org.spring.jdbc.dvdrentaljpa.service;

import org.spring.jdbc.dvdrentaljpa.entity.FilmActor;

import org.spring.jdbc.dvdrentaljpa.repository.FilmActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class FilmActorService {
    private static final Logger logger = Logger.getLogger(FilmActorService.class.getName());

    @Autowired
    private FilmActorRepository filmActorRepository;

    public void insert(FilmActor filmActor){
        logger.info("Insert filmActor: " + filmActor);
        filmActorRepository.save(filmActor);
    }

    public void update(FilmActor filmActor){
        logger.info("Update filmActor: " + filmActor);
        filmActorRepository.save(filmActor);
    }

    public void delete(int id){
        logger.info("Delete filmActor by id: " + id);
        filmActorRepository.deleteById(id);
    }

    public List<FilmActor> getAllFilmActors() {
        logger.info("Select all table: film_actor");
        return filmActorRepository.findAll();
    }

    public Optional<FilmActor> getFilmActorById(int id) {
        logger.info("Select filmActor by id: " + id);
        return filmActorRepository.findById(id);
    }
}
