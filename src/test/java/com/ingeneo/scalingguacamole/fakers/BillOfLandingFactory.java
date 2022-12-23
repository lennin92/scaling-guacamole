package com.ingeneo.scalingguacamole.fakers;

import com.github.javafaker.Faker;
import com.ingeneo.scalingguacamole.entities.BillOfLanding;
import com.github.f4b6a3.ulid.UlidCreator;

public class BillOfLandingFactory extends Factory<BillOfLanding> {

    @Override
    public BillOfLanding Generate() {
        Faker faker = new Faker();
        return BillOfLanding.builder()
                .id(UlidCreator.getMonotonicUlid().toString())
                .fleetNumber(faker.code().gtin8())
                .shipmentPort(faker.address().buildingNumber())
                .billOfLandingNumber(faker.code().gtin8())
                .delivery(new DeliveryFactory().Generate())
                .build();
    }
}
