package fr.mbds.esatic.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    // Récupération d'un utilisateur individuel sur la base de son ID
    public User getUser(Long id)
    {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElse(null);
    }

    // Récupération de tous les utilisateurs
    public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }

    // Création d'un utilisateur
    public User createUser(User user)
    {
        return userRepository.save(user);
    }


}
