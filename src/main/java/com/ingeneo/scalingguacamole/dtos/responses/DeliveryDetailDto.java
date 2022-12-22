package com.ingeneo.scalingguacamole.dtos.responses;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class DeliveryDetailDto {
    private String id;
    private String productTypeId;
    private String productType;
    private String clientId;
    private String clientName;
    private String clientIdentificationNumber;
    private String warehouse;
    private BigDecimal price;
}
