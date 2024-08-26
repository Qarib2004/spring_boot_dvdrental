package org.spring.jdbc.dvdrentaljpa.repository;

import org.spring.jdbc.dvdrentaljpa.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film,Integer> {
}
