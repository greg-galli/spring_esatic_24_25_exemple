package fr.mbds.esatic.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    UserRepository userRepository;

    public ApiController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return user;
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/user/{id}")
    public User editFullUser(@PathVariable Long id) {
        return null;
    }

    @PatchMapping("/user/{id}")
    public User editUser(@PathVariable Long id) {
        return null;
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Long id) {

    }
}
