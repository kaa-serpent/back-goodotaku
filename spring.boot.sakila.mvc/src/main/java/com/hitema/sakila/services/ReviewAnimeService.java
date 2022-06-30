package com.hitema.sakila.services;

import com.hitema.sakila.entities.ReviewsAnime;
import com.hitema.sakila.entities.User;

import java.util.List;

public interface ReviewAnimeService {

    List<ReviewsAnime> listAll();

    List<User> listUser();

    ReviewsAnime get(Long id);

    void delete(Long id);
}
