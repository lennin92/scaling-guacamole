package com.ingeneo.scalingguacamole.services.impl;

import com.ingeneo.scalingguacamole.dtos.UserDetailsImp;
import com.ingeneo.scalingguacamole.dtos.requests.LoginDto;
import com.ingeneo.scalingguacamole.entities.User;
import com.ingeneo.scalingguacamole.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    private UserRepository repository;
    private PasswordEncoder encoder;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
        this.encoder = new BCryptPasswordEncoder();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> ou = this.repository.findByUsername(username);
        if(ou.isEmpty()){
            throw new UsernameNotFoundException("User doesnt exists");
        }
        User u = ou.get();
        return UserDetailsImp.builder().password(u.getPassword()).username(u.getUsername()).build();
    }

    public User createUser(LoginDto req){
        User u = User.builder()
                .password(this.encoder.encode(req.getPassword()))
                .username(req.getUsername())
                .build();
        return this.repository.save(u);
    }
}
