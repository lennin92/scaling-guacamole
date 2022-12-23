package com.ingeneo.scalingguacamole.fakers;

import com.github.f4b6a3.ulid.UlidCreator;
import com.github.javafaker.Faker;
import com.ingeneo.scalingguacamole.entities.ProductType;

public class ProductTypeFactory extends Factory<ProductType> {

    @Override
    public ProductType Generate() {
        Faker faker = new Faker();
        return ProductType.builder()
                .id(UlidCreator.getMonotonicUlid().toString())
                .productTypeName(faker.name().fullName())
                .build();
    }
}
