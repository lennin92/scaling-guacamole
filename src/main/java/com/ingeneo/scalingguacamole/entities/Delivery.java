package com.ingeneo.scalingguacamole.entities;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Getter
@Setter
@Builder
@Entity(name = "delivery")
public class Delivery {
    private String id;
    private Client client;
    private ProductType productType;
    private ZonedDateTime registeredAt;
    private ZonedDateTime estimatedDeliveryDate;
    private BigDecimal deliveryPrice;
}
