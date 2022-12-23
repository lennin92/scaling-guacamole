package com.ingeneo.scalingguacamole.dtos.requests;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Date;

@Getter
@Setter
public class CreateDeliveryDto {
    private String productTypeId;
    private String clientId;
    private BigDecimal price;
    private BigDecimal productQuantity;
    private Date estimatedDeliveryTime;
}
