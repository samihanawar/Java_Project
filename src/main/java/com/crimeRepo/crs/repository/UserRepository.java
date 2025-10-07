package com.crimeRepo.crs.repository;

import com.crimeRepo.crs.entities.User;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

//    Optional<User> findByUsername(String username);

    Optional<User> findByRole(String role);
    @Query("SELECT u FROM User u WHERE u.role = 'USER'")
    List<User> findAllCitizens();
    @Query("SELECT u FROM User u WHERE u.role = 'POLICE'")
    List<User> findAllPolice();


}
