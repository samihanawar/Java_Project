package com.crimeRepo.crs.service;

import com.crimeRepo.crs.entities.User;
import com.crimeRepo.crs.repository.UserRepository;
import java.util.*;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User saveUser(User user) {
        //String userId = UUID.randomUUID().toString();
        user.setId(user.getId());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));
    }


    public List<User> getAllCitizens() {
        return userRepository.findAllCitizens();
    }

    public List<User> getAllPolice() {
        return userRepository.findAllPolice();
    }

}
