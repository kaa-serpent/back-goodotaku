package com.hitema.goodreads.controllers.api;

import com.hitema.goodreads.entities.ReviewsAnime;
import com.hitema.goodreads.repositories.ReviewAnimeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:8082")
@RestController
@RequestMapping("/api")
public class ReviewsAnimeApiController {

    private Logger logger = LoggerFactory.getLogger(ReviewsAnimeApiController.class);

    @Autowired
    private ReviewAnimeRepository reviewAnimeRepository;

    @GetMapping("/reviews-anime")
    public ResponseEntity<Object> getAllReviewsAnime(){
        try {
            Iterable<ReviewsAnime> reviewsAnime = reviewAnimeRepository.findAll();
            return new ResponseEntity<Object>(reviewsAnime, HttpStatus.OK);
        } catch(Exception ex) {
            logger.error(ex.getMessage(), ex);
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/reviews-anime/{id}")
    public ResponseEntity<Object> getReviewsAnimeById(@PathVariable("id") Long id) {
        try {
            ReviewsAnime reviewsAnime = reviewAnimeRepository.findById(id).get();
            if(reviewsAnime != null) {
                return new ResponseEntity<Object>(reviewsAnime, HttpStatus.OK);
            } else {
                return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
            }
        } catch(Exception ex) {
            logger.error(ex.getMessage(), ex);
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/reviews-anime/save")
    public ResponseEntity<Object> saveReviewAnime(ReviewsAnime reviewsAnime) {
        try {
            ReviewsAnime reviewsAnimes = reviewAnimeRepository.save(reviewsAnime);
            if (reviewsAnimes != null) {
                return new ResponseEntity<Object>(reviewsAnimes, HttpStatus.OK);
            } else {
                return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }

    }


}