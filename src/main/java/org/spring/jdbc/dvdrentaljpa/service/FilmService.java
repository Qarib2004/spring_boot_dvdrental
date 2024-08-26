package org.spring.jdbc.dvdrentaljpa.service;

import org.spring.jdbc.dvdrentaljpa.entity.Film;
import org.spring.jdbc.dvdrentaljpa.repository.FilmRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class FilmService {
    private static final Logger logger = Logger.getLogger(FilmService.class.getName());

    @Autowired
    private FilmRepository filmRepository;


    public void insert(Film film){
        logger.info("Insert film: " + film);
        filmRepository.save(film);
    }


    public void update(Film film_id){
        logger.info("Update film by id: " + film_id);
        filmRepository.save(film_id);
    }

    public void delete(int film_id){
        logger.info("Delete film by id: " + film_id);
        filmRepository.deleteById(film_id);
    }

    public List<Film> getAllFilms() {
        logger.info("Select all table: film");
        return filmRepository.findAll();
    }

    public Optional<Film> getFilmById(int film_id) {
        logger.info("Select film by id: " + film_id);
        return filmRepository.findById(film_id);
    }
}
