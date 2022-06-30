package com.hitema.sakila.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
    @RequestMapping("/")
public class WelcomeController {
    private static final Logger log = LoggerFactory.getLogger(WelcomeController.class);

    @GetMapping
    public ModelAndView index(ModelMap model) {
        String message = "Nous sommes le, "+LocalDateTime.now().format(DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy"));
        model.addAttribute("message",message);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }
}