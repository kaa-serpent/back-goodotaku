package com.hitema.goodreads.controllers.api;

import com.hitema.goodreads.entities.Genres;
import com.hitema.goodreads.repositories.GenresRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:8082")
@RestController
@RequestMapping("/api")
public class GenreApiController {

    private Logger logger = LoggerFactory.getLogger(GenreApiController.class);

    @Autowired
    private GenresRepository genreRepository;

    @GetMapping("/genres")
    public ResponseEntity<Object> getAllGenre(){
        try {
            Iterable<Genres> genres = genreRepository.findAll();
            return new ResponseEntity<Object>(genres, HttpStatus.OK);
        } catch(Exception ex) {
            logger.error(ex.getMessage(), ex);
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/genres/{id}")
    public ResponseEntity<Object> getGenreById(@PathVariable("id") Long id) {
        try {
            Genres genres = genreRepository.findById(id).get();
            if(genres != null) {
                return new ResponseEntity<Object>(genres, HttpStatus.OK);
            } else {
                return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
            }
        } catch(Exception ex) {
            logger.error(ex.getMessage(), ex);
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }


}