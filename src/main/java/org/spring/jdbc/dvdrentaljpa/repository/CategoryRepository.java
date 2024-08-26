package org.spring.jdbc.dvdrentaljpa.repository;

import org.spring.jdbc.dvdrentaljpa.entity.Address;
import org.spring.jdbc.dvdrentaljpa.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository  extends JpaRepository<Category, Integer> {
}
