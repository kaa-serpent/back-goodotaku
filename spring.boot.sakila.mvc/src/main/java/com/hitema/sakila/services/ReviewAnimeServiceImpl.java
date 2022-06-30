package com.hitema.sakila.services;

import com.hitema.sakila.entities.ReviewsAnime;
import com.hitema.sakila.entities.Role;
import com.hitema.sakila.entities.User;
import com.hitema.sakila.repositories.ReviewAnimeRepository;
import com.hitema.sakila.repositories.RoleRepository;
import com.hitema.sakila.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewAnimeServiceImpl implements ReviewAnimeService{

    @Autowired
    private ReviewAnimeRepository revAnimRepo;

    @Autowired
    UserRepository userRepo;

    public List<ReviewsAnime> listAll() {
        return revAnimRepo.findAll();
    }

    public ReviewsAnime get(Long id) {
        return revAnimRepo.findById(id).get();
    }

    public List<User> listUser() {
        return userRepo.findAll();
    }

    public void delete(Long id) {
        revAnimRepo.deleteById(id);
    }

}
