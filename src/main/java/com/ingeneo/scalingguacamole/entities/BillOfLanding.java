package com.ingeneo.scalingguacamole.entities;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity(name = "bill_of_landing")
public class BillOfLanding {
    private String id;
    private Delivery delivery;
    private String shipmentPort;
    private String fleetNumber;
    private String billOfLandingNumber;
}
