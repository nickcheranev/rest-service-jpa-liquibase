package com.example.restservicejpaliquibase.jpa;


import com.example.restservicejpaliquibase.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Cheranev N.
 * created on 20.08.2020.
 */
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAll();
}
