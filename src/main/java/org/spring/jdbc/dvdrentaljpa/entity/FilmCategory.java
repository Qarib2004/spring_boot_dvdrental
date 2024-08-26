package org.spring.jdbc.dvdrentaljpa.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
@Table(name = "film_category")
public class FilmCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int filmCategoryId;
    @ManyToOne
    @JoinColumn(name = "category_id",nullable = false)
    private Category category;
    @Column(name = "last_update")
    private LocalDateTime last_update;

    public FilmCategory(int filmCategoryId, Category category, LocalDateTime last_update) {
        this.filmCategoryId = filmCategoryId;
        this.category = category;
        this.last_update = last_update;
    }

    public FilmCategory() {
    }

    public int getFilmCategoryId() {
        return filmCategoryId;
    }

    public void setFilmCategoryId(int filmCategoryId) {
        this.filmCategoryId = filmCategoryId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public LocalDateTime getLast_update() {
        return last_update;
    }

    public void setLast_update(LocalDateTime last_update) {
        this.last_update = last_update;
    }

    @Override
    public String toString() {
        return "FilmCategory{" +
                "film_id=" + filmCategoryId +
                ", category=" + category +
                ", last_update=" + last_update +
                '}';
    }
}
