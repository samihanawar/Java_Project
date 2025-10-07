package com.crimeRepo.crs.service;

import com.crimeRepo.crs.entities.User;
import com.crimeRepo.crs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PoliceService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllPolice() {
        return userRepository.findAllPolice();
    }
}
