package com.example.restservicejpaliquibase.service;

import com.example.restservicejpaliquibase.domain.User;
import com.example.restservicejpaliquibase.jpa.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Cheranev N.
 * created on 20.08.2020.
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(Long id, User user) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User updatedUser = optionalUser.get();
            updatedUser.setName(user.getName());
            updatedUser.setEmail(user.getEmail());
            userRepository.save(updatedUser);
            return updatedUser;
        } else
            throw new ResourceNotFoundException();
    }

    @Override
    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent())
            return user.get();
        else
            throw new ResourceNotFoundException();
    }

    @Override
    public void deleteById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent())
            userRepository.deleteById(id);
        else
            throw new ResourceNotFoundException();
    }
}
