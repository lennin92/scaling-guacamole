package com.ingeneo.scalingguacamole.dtos.responses;

import lombok.*;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WaybillDetailDto {
    private String trucksPlate;
    private String waybillNumber;
    private String id;
    private String productTypeId;
    private String productType;
    private String clientId;
    private String clientName;
    private String clientIdentificationNumber;
    private String warehouse;
    private BigDecimal price;
    private Date estimatedDeliveryTime;
    private Date registeredAt;
    private BigDecimal quantity;
    private BigDecimal priceWithDiscount;
}
