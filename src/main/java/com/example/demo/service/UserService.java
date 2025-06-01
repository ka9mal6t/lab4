package com.example.demo.service;

import com.example.demo.models.UserProfile;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<UserProfile> getAllUsers() {
        return userRepository.findAll();
    }

    public UserProfile getUser(int id) {
        Optional<UserProfile> userProfile = userRepository.findById(id);
        return userProfile.orElse(null);
    }

    public UserProfile getUserByUsername(String username) {
        Optional<UserProfile> userProfile = Optional.ofNullable(userRepository.findByUsername(username));
        return userProfile.orElse(null);
    }
}