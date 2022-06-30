package com.hitema.sakila.services;

import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@SpringBootTest
    @TestInstance(PER_CLASS)
        @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CityServiceImplTest {

    private static final Logger log = LoggerFactory.getLogger(CityServiceImplTest.class);

    @Autowired
    private CityService service;

    @BeforeEach
    void setUp() {

    }

    @Test
    void readAll() {
    }

    @Test
    void create() {
    }

    @Test
    void read() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
        @DisplayName("Should return All Cities who are Capitals")
    void shouldReturnAllCitiesWhoAreCapitals() {
        log.info("<<<START shouldReturnAllCitiesWhoAreCapitals >>>");
        log.info("<<<From Magic - MethodName>>>");
        service.readAllCapitals().forEach(c->log.info("{}",c));
        log.info("<<<END   shouldReturnAllCitiesWhoAreCapitals >>>");
    }

    @Test
    @DisplayName("Should return All city wich name contains specific string")
    void shouldReturnAllCityWichNameContainsSpecificString() {
        log.info("<<<START shouldReturnAllCityWichNameContainsSpecificString >>>");
        String name = "pa" ;
        var cities = service.readNameLike(name);
        cities.forEach(c->log.trace("{}",c));
        log.info("Number of cities founded with name like {} :{}",name, cities.size());
        name = "tri" ;
        cities = service.readNameLike(name);
        cities.forEach(c->log.trace("{}",c));
        log.info("Number of cities founded with name like {} :{}",name, cities.size());
        name = "so" ;
        cities = service.readNameLike(name);
        cities.forEach(c->log.trace("{}",c));
        log.info("Number of cities founded with name like {} :{}",name, cities.size());
        log.info("<<<END   shouldReturnAllCityWichNameContainsSpecificString >>>");
    }
}