package com.ingeneo.scalingguacamole.entities;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity(name = "waybill")
public class WayBill {
    private String id;
    private Delivery delivery;
    private String warehouse;
    private String trucksPlate;
    private String waybillNumber;
}
