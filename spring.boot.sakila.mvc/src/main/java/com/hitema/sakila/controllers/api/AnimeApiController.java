package com.hitema.goodreads.controllers.api;

import com.hitema.goodreads.entities.Animes;
import com.hitema.goodreads.repositories.AnimesRepository;
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
public class AnimeApiController {

    private Logger logger = LoggerFactory.getLogger(UserApiController.class);

    @Autowired
    private AnimesRepository animeRepository;

    @GetMapping("/animes")
    public ResponseEntity<Object> getAllAnime(){
        try {
            Iterable<Animes> animes = animeRepository.findAll();
            return new ResponseEntity<Object>(animes, HttpStatus.OK);
        } catch(Exception ex) {
            logger.error(ex.getMessage(), ex);
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/animes/{id}")
    public ResponseEntity<Object> getAnimeById(@PathVariable("id") Long id) {
        try {
            Animes animes = animeRepository.findById(id).get();
            if(animes != null) {
                return new ResponseEntity<Object>(animes, HttpStatus.OK);
            } else {
                return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
            }
        } catch(Exception ex) {
            logger.error(ex.getMessage(), ex);
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }


}