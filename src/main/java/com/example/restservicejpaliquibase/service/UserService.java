package com.example.restservicejpaliquibase.service;

import com.example.restservicejpaliquibase.domain.User;

import java.util.List;

/**
 * @author Cheranev N.
 * created on 20.08.2020.
 */
public interface UserService {
    List<User> findAll();

    User create(User user);

    User update(Long id, User user);

    User findById(Long id);

    void deleteById(Long id);
}
