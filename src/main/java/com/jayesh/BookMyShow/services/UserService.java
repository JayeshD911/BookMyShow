package com.jayesh.BookMyShow.services;

import com.jayesh.BookMyShow.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jayesh.BookMyShow.repos.UserRepo;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepo userRepo;
    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    public User signUpUser(String name, String email, String password) {
        // check if user with email already exists
        Optional<User> userOptional = userRepo.findByEmail(email);
        if(userOptional.isPresent()) {
            throw new RuntimeException("User with email already exists");
        }
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        return userRepo.save(user);
    }

}
