package com.ingeneo.scalingguacamole.dtos.requests;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CreateDeliveryDto {
    private String id;
    private String productTypeId;
    private String clientId;
    private String warehouse;
    private BigDecimal price;
}
