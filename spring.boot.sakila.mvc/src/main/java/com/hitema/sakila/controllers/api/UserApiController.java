package com.hitema.goodreads.controllers.api;

import com.hitema.goodreads.entities.User;
import com.hitema.goodreads.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:8082")
@RestController
@RequestMapping("/api")
public class UserApiController {

    private Logger logger = LoggerFactory.getLogger(UserApiController.class);

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public ResponseEntity<Object> getAllUsers(){
        try {
            Iterable<User> users = userRepository.findAll();
            return new ResponseEntity<Object>(users, HttpStatus.OK);
        } catch(Exception ex) {
            logger.error(ex.getMessage(), ex);
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/users/save")
    public ResponseEntity<Object> saveUser(User user) {
        try {
            User users = userRepository.save(user);
            if(users != null) {
                return new ResponseEntity<Object>(users, HttpStatus.OK);
            } else {
                return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
            }
        } catch(Exception ex) {
            logger.error(ex.getMessage(), ex);
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }




}