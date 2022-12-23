package com.ingeneo.scalingguacamole.repositories;

import com.ingeneo.scalingguacamole.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository
        extends JpaRepository<User, String> {
    Optional<User> findByUserName(String userName);
}
