package org.spring.jdbc.dvdrentaljpa.service;

import org.spring.jdbc.dvdrentaljpa.entity.FilmCategory;
import org.spring.jdbc.dvdrentaljpa.repository.FilmCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class FilmCategoryService {
    private static final Logger logger = Logger.getLogger(FilmCategoryService.class.getName());

    @Autowired
    private FilmCategoryRepository filmCategoryRepository;

    public void insert(FilmCategory filmCategory) {
        logger.info("Insert film category: " + filmCategory);
       filmCategoryRepository.save(filmCategory);
    }

    public void update(FilmCategory filmCategoryId) {
        logger.info("Update film category by id: " + filmCategoryId);
      filmCategoryRepository.save(filmCategoryId);
    }

    public void delete(int filmId) {
        logger.info("Delete film category by id: " + filmId);
        filmCategoryRepository.deleteById(filmId);
    }

    public List<FilmCategory> getAllFilmCategories() {
        logger.info("Select all table: film_category");
        return filmCategoryRepository.findAll();
    }

    public Optional<FilmCategory> getFilmCategoryById(int filmId) {
        logger.info("Select film category by id: " + filmId);
        return filmCategoryRepository.findById(filmId);
    }
}
