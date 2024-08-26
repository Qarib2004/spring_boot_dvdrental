package org.spring.jdbc.dvdrentaljpa.repository;

import org.spring.jdbc.dvdrentaljpa.entity.FilmActor;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FilmActorRepository extends JpaRepository<FilmActor,Integer> {

}
