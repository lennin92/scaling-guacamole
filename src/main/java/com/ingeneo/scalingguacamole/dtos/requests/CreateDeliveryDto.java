package com.ingeneo.scalingguacamole.dtos.requests;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Getter
@Setter
public class CreateDeliveryDto {
    private String productTypeId;
    private String clientId;
    private BigDecimal price;
    private BigDecimal productQuantity;
    private ZonedDateTime estimatedDeliveryTime;
}
