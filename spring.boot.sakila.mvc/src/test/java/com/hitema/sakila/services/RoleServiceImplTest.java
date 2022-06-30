package com.hitema.sakila.services;

import com.hitema.sakila.entities.Role;
import com.hitema.sakila.repositories.RoleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class RoleServiceImplTest {

    @Autowired
    private RoleRepository repo;

    @Test
    public void testCreateRoles() {
        Role user = new Role("User");

        repo.saveAll(List.of(user));

        List<Role> listRoles = repo.findAll();

        assertThat(listRoles.size()).isEqualTo(20);
    }

}
