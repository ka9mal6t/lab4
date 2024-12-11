package com.example.demo.service;

import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(int id) {
        Optional<User> userProfile = userRepository.findById(id);
        return userProfile.orElse(null);
    }

    public User getUserByUsername(String username) {
        Optional<User> userProfile = Optional.ofNullable(userRepository.findByUsername(username));
        return userProfile.orElse(null);
    }
}