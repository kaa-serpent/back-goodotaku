package com.hitema.sakila.controllers;

import com.hitema.sakila.entities.Animes;
import com.hitema.sakila.entities.Genres;
import com.hitema.sakila.services.AnimesService;
import com.hitema.sakila.services.ReviewAnimeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8082")
@RestController
public class AnimeController {
    private static final Logger log = LoggerFactory.getLogger(WelcomeController.class);
    @Autowired
    private AnimesService service;

    @Autowired
    private ReviewAnimeService serviceReview;

    @RequestMapping("/animes/list")
    public ModelAndView animesList(ModelMap model){
        log.trace("User List called");
        model.addAttribute("animes", service.listAll());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("animes_list");
        return modelAndView;
    }

    @RequestMapping({"/{id}","/animes/list/details/{id}"})
    public ModelAndView detailsAnime(@PathVariable("id") Long id, Model model) {
        log.trace("Edit User  called");
        Animes animes = service.get(id);
        List<Genres> listGenres = service.listGenres();
        model.addAttribute("animes", animes);
        model.addAttribute("listGenres", listGenres);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("anime_details");
        return modelAndView;
    }

    @RequestMapping({"/{id}","/animes/list/details/edit/{id}"})
    public ModelAndView editAnime(@PathVariable("id") Long id, Model model) {
        log.trace("Edit User  called");
        Animes animes = service.get(id);
        List<Genres> listGenres = service.listGenres();
        model.addAttribute("animes", animes);
        model.addAttribute("listGenres", listGenres);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("anime_form");
        return modelAndView;
    }

    @RequestMapping({"/save","/animes/save"})
    public ModelAndView saveAnime(Animes anime) {
        service.save(anime);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping("/animes/create")
    public ModelAndView createAnime(ModelMap model){
        List<Genres> listGenres = service.listGenres();
        model.addAttribute("animes", new Animes());
        model.addAttribute("listGenres", listGenres);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("anime_form");
        return modelAndView;
    }

    @RequestMapping({"/{id}","/animes/list/delete/{id}"})
    public ModelAndView deleteAnime(@PathVariable("id") Long id, Model model) {
        service.delete(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping({"/{id}","/animes/list/details/delete/{id}"})
    public ModelAndView deleteReviewAnime(@PathVariable("id") Long id, Model model) {
        serviceReview.delete(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

}
