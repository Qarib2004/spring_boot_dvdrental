package org.spring.jdbc.dvdrentaljpa.service;

import org.spring.jdbc.dvdrentaljpa.entity.Category;
import org.spring.jdbc.dvdrentaljpa.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class CategoryService {
    private static final Logger logger = Logger.getLogger(CategoryService.class.getName());

    @Autowired
    private CategoryRepository categoryRepository;

    public void insert(Category category){
        logger.info("Insert category: " + category);
        categoryRepository.save(category);
    }

    public void update(Category category_id){
        logger.info("Update category by id: " + category_id);
        categoryRepository.save(category_id);
    }

    public void delete(int category_id){
        logger.info("Delete category by id: " + category_id);
        categoryRepository.deleteById(category_id);
    }

    public List<Category> getAllCategories() {
        logger.info("Select all table: category");
        return categoryRepository.findAll();
    }

    public Optional<Category> getCategoryById(int category_id) {
        logger.info("Select category by id: " + category_id);
        return categoryRepository.findById(category_id);
    }
}
