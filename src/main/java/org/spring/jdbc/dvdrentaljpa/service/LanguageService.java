package org.spring.jdbc.dvdrentaljpa.service;

import org.spring.jdbc.dvdrentaljpa.entity.Language;
import org.spring.jdbc.dvdrentaljpa.repository.LanguageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class LanguageService  {
    private static final Logger logger = Logger.getLogger(LanguageService.class.getName());

    @Autowired
    private LanguageRepository languageRepository;


    public void insert(Language language) {
        logger.info("Insert language: " + language);
        languageRepository.save(language);
    }


    public void update(Language languageId) {
        logger.info("Update language by id: " + languageId);
        languageRepository.save(languageId);
    }


    public void delete(int languageId) {
        logger.info("Delete language by id: " + languageId);
        languageRepository.deleteById(languageId);
    }

    public List<Language> getAllLanguages() {
        logger.info("Select all table: language");
        return languageRepository.findAll();
    }

    public Optional<Language> getLanguageById(int languageId) {
        logger.info("Select language by id: " + languageId);
        return languageRepository.findById(languageId);
    }


}
