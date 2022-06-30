package com.hitema.sakila.services;

import com.hitema.sakila.entities.Animes;
import com.hitema.sakila.entities.Genres;
import com.hitema.sakila.entities.Role;
import com.hitema.sakila.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AnimesService {

    List<Animes> listAll();

    List<Genres> listGenres();

    Animes get(Long id);

    void save(Animes anime);

    void delete(Long id);
}
