package org.spring.jdbc.dvdrentaljpa.repository;

import org.spring.jdbc.dvdrentaljpa.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language,Integer> {
}
