package com.ingeneo.scalingguacamole.fakers;

import com.github.f4b6a3.ulid.UlidCreator;
import com.github.javafaker.Faker;
import com.ingeneo.scalingguacamole.entities.WayBill;

public class WaybillFactory extends Factory<WayBill> {

    @Override
    public WayBill Generate() {
        Faker faker = new Faker();
        return WayBill.builder()
                .id(UlidCreator.getMonotonicUlid().toString())
                .trucksPlate(faker.code().gtin8())
                .warehouse(faker.address().buildingNumber())
                .waybillNumber(faker.code().gtin8())
                .delivery(new DeliveryFactory().Generate())
                .build();
    }
}
