package com.ingeneo.scalingguacamole.services;

import com.github.javafaker.Faker;
import com.ingeneo.scalingguacamole.dtos.requests.LoginDto;
import com.ingeneo.scalingguacamole.entities.User;
import com.ingeneo.scalingguacamole.fakers.UserFactory;
import com.ingeneo.scalingguacamole.repositories.UserRepository;
import com.ingeneo.scalingguacamole.services.impl.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceTest {
    @Test
    public void getUserTestByUsername(){
        String password = Faker.instance().witcher().character();
        User u = new UserFactory().GenerateWithPassword(password);
        String username = u.getUsername();

        UserRepository repo = mock(UserRepository.class);
        when(repo.findByUsername(anyString())).thenReturn(Optional.of(u));
        UserService service = new UserService(repo);
        UserDetails ud = service.loadUserByUsername(username);

        Assert.assertEquals(u.getUsername(), ud.getUsername());
        Assert.assertTrue(new BCryptPasswordEncoder().matches(password, u.getPassword()));
        Assert.assertTrue(new BCryptPasswordEncoder().matches(password, ud.getPassword()));
    }

    @Test
    public void createUserTest(){
        String password = Faker.instance().witcher().quote();
        User u = new UserFactory().GenerateWithPassword(password);
        LoginDto inputDto = new LoginDto();
        inputDto.setPassword(password);
        inputDto.setUsername(u.getUsername());

        UserRepository repo = mock(UserRepository.class);
        when(repo.save(any())).thenReturn(u);
        UserService service = new UserService(repo);
        User uc = service.createUser(inputDto);

        Assert.assertEquals(u.getUsername(), uc.getUsername());
        Assert.assertTrue(new BCryptPasswordEncoder().matches(password, u.getPassword()));
        Assert.assertTrue(new BCryptPasswordEncoder().matches(password, uc.getPassword()));

    }
}
