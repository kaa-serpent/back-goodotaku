package com.hitema.sakila.services;


import com.hitema.sakila.entities.Role;
import com.hitema.sakila.entities.User;

import java.util.List;

public interface UserService {

    List<User> listAll();

    List<Role> listRoles();

    User get(Long id);

    void save(User user);

    void delete(Long id);
}
