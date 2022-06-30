package com.hitema.sakila.repositories;

import com.hitema.sakila.entities.Genres;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenresRepository extends JpaRepository<Genres, Long> {
}
