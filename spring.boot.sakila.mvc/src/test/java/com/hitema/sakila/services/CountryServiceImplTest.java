package com.hitema.sakila.services;

import com.hitema.sakila.entities.Country;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;


@SpringBootTest
    @TestInstance(PER_CLASS)
        @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CountryServiceImplTest {

    private static final Logger log = LoggerFactory.getLogger(CountryServiceImplTest.class);

    @Autowired
    private CountryService service;

    private Country country ;


    @BeforeEach
    void setUp() {
        log.info("<<<<<<Before Each>>>>>>");
        assertTrue(service!=null, "Service Country NOT Injected !!!");
    }

    @Test
        @Disabled
    void readAll() {
        Long number = 109l;
        log.info("<<<<<<Start GetAll Test>>>>>>");
        var countries = service.readAll();
        countries.forEach(c-> {
            log.trace("{}",c) ;
            c.getCities().forEach(cty-> log.trace("{}"));
        });
        log.info("Number of Countries : {}",countries.size());
        assertEquals(number,countries.size(),"ERROR Countries Number not CORRECT !!!");
        log.info("<<<<<<End   GetAll Test>>>>>>");
    }


    @Test
        @DisplayName("Should Read One Country and List all Cities")
            @Transactional
                @Disabled
    void shouldReadOneCountryAndListAllCities() {
        log.info("<<<START shouldReadOneCountryAndListAllCities >>>");
        Long id = 23l;
        var country = service.read(id);
        assertNotNull(country,"ERROR Country Id :"+id+" NOT Found !!!");
        log.info("Found country : {}",country);
        var cities = country.getCities();
        log.info("Number of cities : {}",cities.size());
        cities.forEach(c->log.trace("{}",c));
        log.info("<<<END   shouldReadOneCountryAndListAllCities >>>");
    }

    @Test
        @DisplayName("Should Create New Country")
            @Order(0)
    void shouldCreateNewCountry() {
        log.info("<<<START shouldCreateNewCountry >>>");
        country = new Country();
        country.setCountry("Country TEST");
        country.setLastUpdate(LocalDateTime.now());
        service.create(country);
        assertNotNull(country.getId(),"ERROR Country NOT CREATED !!!!");
        log.info("Country Created : {}",country);
        log.info("<<<END   shouldCreateNewCountry >>>");
    }

    @Test
        @DisplayName("Should Read New Created Country")
            @Order(1)
    void shouldReadNewCreatedCountry() {
        log.info("<<<START shouldReadNewCreatedCountry >>>");
        var newCountry = service.read(country.getId());
        assertNotNull(newCountry,"ERROR New Created Country cannot be found !!!!");
        log.info("<<<END   shouldReadNewCreatedCountry >>>");
    }

    @Test
    @DisplayName("Should Update new Created Country")
        @Order(2)
    void shouldUpdateNewCreatedCountry() {
        log.info("<<<START shouldUpdateNewCreatedCountry >>>");
        
        log.info("<<<END   shouldUpdateNewCreatedCountry >>>");
    }

    @Test
        @DisplayName("Should Delete new Created Country")
            @Order(3)
    void shouldDeleteNewCreatedCountry() {
        log.info("<<<START shouldDeleteNewCreatedCountry >>>");
        assertTrue(service.delete(country.getId()),"ERROR While DELETE New Created Country, id"+country.getId());
        log.info("country Id:{} deleted",country.getId());
        log.info("<<<END   shouldDeleteNewCreatedCountry >>>");
    }
}