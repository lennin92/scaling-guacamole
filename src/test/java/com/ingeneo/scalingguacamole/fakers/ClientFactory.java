package com.ingeneo.scalingguacamole.fakers;

import com.github.f4b6a3.ulid.UlidCreator;
import com.github.javafaker.Faker;
import com.ingeneo.scalingguacamole.entities.Client;

public class ClientFactory extends Factory<Client> {

    @Override
    public Client Generate() {
        Faker faker = new Faker();
        return Client.builder()
                .id(UlidCreator.getMonotonicUlid().toString())
                .clientsName(faker.name().fullName())
                .clientsIdentification(faker.idNumber().toString())
                .build();
    }
}
