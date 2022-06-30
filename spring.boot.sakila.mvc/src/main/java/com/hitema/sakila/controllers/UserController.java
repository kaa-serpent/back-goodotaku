package com.hitema.sakila.controllers;
import com.hitema.sakila.entities.Role;
import com.hitema.sakila.entities.User;
import com.hitema.sakila.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(WelcomeController.class);
    @Autowired
    private UserService service;

    @RequestMapping("/users")
    public ModelAndView userList(ModelMap model){
        log.trace("User List called");
        model.addAttribute("users", service.listAll());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users");
        return modelAndView;
    }

    @RequestMapping({"/{id}","/users/list/edit/{id}"})
    public ModelAndView editUser(@PathVariable("id") Long id, Model model) {
        log.trace("Edit User  called");
        User user = service.get(id);
        List<Role> listRoles = service.listRoles();
        model.addAttribute("user", user);
        model.addAttribute("listRoles", listRoles);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user_form");
        return modelAndView;
    }

    @RequestMapping({"/save","/users/save"})
    public ModelAndView saveUser(User user) {
        service.save(user);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping("/users/create")
    public ModelAndView createUser(ModelMap model){
        List<Role> listRoles = service.listRoles();
        model.addAttribute("user", new User());
        model.addAttribute("listRoles", listRoles);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user_form");
        return modelAndView;
    }

    @RequestMapping({"/{id}","/users/list/delete/{id}"})
    public ModelAndView deleteUser(@PathVariable("id") Long id, Model model) {
        service.delete(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
