package com.example.restservicejpaliquibase.web;

import com.example.restservicejpaliquibase.domain.User;
import com.example.restservicejpaliquibase.service.ResourceNotFoundException;
import com.example.restservicejpaliquibase.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author Cheranev N.
 * created on 20.08.2020.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User update(@PathVariable("id") Long id, @RequestBody User user) {
        return userService.update(id, user);
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User findById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable("id") Long id) {
        userService.deleteById(id);
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    public void handleResourceNotFoundException(HttpServletResponse response) {
        response.setStatus(HttpStatus.PRECONDITION_FAILED.value());
    }
}
