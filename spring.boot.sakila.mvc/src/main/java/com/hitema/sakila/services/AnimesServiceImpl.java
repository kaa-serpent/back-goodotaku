package com.hitema.sakila.services;

import com.hitema.sakila.entities.Animes;
import com.hitema.sakila.entities.Genres;
import com.hitema.sakila.entities.Role;
import com.hitema.sakila.entities.User;
import com.hitema.sakila.repositories.AnimesRepository;
import com.hitema.sakila.repositories.GenresRepository;
import com.hitema.sakila.repositories.RoleRepository;
import com.hitema.sakila.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimesServiceImpl implements AnimesService {

    @Autowired
    private AnimesRepository animeRepo;

    @Autowired
    GenresRepository genreRepo;

    public List<Animes> listAll() {
        return animeRepo.findAll();
    }

    public Animes get(Long id) {
        return animeRepo.findById(id).get();
    }

    public List<Genres> listGenres() {
        return genreRepo.findAll();
    }

    public void save(Animes anime) {
        animeRepo.save(anime);
    }

    public void delete(Long id) {
        animeRepo.deleteById(id);
    }
}
