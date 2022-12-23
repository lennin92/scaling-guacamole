package com.ingeneo.scalingguacamole.fakers;

import com.github.f4b6a3.ulid.UlidCreator;
import com.github.javafaker.Faker;
import com.ingeneo.scalingguacamole.entities.BillOfLanding;
import com.ingeneo.scalingguacamole.entities.Client;
import com.ingeneo.scalingguacamole.entities.Delivery;
import com.ingeneo.scalingguacamole.entities.ProductType;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

public class DeliveryFactory extends Factory<Delivery> {

    @Override
    public Delivery Generate() {
        Faker faker = new Faker();
        BigDecimal price = BigDecimal.valueOf(faker.number().randomDouble(2, 1, 500));
        BigDecimal qty = BigDecimal.valueOf(faker.number().randomDouble(2, 1, 50));
        Client c = new ClientFactory().Generate();
        ProductType pt = new ProductTypeFactory().Generate();
        return Delivery.builder()
                .id(UlidCreator.getMonotonicUlid().toString())
                .deliveryPrice(price)
                .productQuantity(qty)
                .client(c)
                .estimatedDeliveryDate(faker.date().future(15, TimeUnit.DAYS))
                .productType(pt)
                .build();
    }
}
