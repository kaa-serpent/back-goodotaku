package com.hitema.sakila.repositories;

import com.hitema.sakila.entities.Animes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AnimesRepository extends JpaRepository<Animes, Long> {
}
