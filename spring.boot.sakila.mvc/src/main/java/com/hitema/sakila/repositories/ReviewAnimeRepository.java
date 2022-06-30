package com.hitema.sakila.repositories;

import com.hitema.sakila.entities.ReviewsAnime;
import com.hitema.sakila.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReviewAnimeRepository  extends JpaRepository<ReviewsAnime,Long>{
    @Query("SELECT r FROM ReviewsAnime r WHERE r.id = ?1")
    public ReviewsAnime findByAnimeId(Long id);
}
