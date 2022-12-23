package com.ingeneo.scalingguacamole.fakers;

import com.github.f4b6a3.ulid.UlidCreator;
import com.github.javafaker.Faker;
import com.ingeneo.scalingguacamole.entities.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserFactory extends Factory<User> {

    @Override
    public User Generate() {
        Faker faker = new Faker();
        return User.builder()
                .id(UlidCreator.getMonotonicUlid().toString())
                .username(faker.name().username())
                .build();
    }
    public User GenerateWithPassword(String password){
        BCryptPasswordEncoder enc = new BCryptPasswordEncoder();
        User u = this.Generate();
        u.setPassword(enc.encode(password));
        return u;
    }
}
