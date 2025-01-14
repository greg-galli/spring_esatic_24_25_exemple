package fr.mbds.esatic.user;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @GetMapping(value = "/user/{id}")
    public User getUser(@PathVariable Long id)
    {
        User userInstance = userService.getUser(id);
        if (userInstance == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return userInstance;
    }

    @GetMapping(value = "/users")
    public List<User> getUsers()
    {
        return userService.getAllUsers();
    }

    @PostMapping(value = "/users")
    public User createUser(@RequestBody User user)
    {
        return userService.createUser(user);
    }
}
