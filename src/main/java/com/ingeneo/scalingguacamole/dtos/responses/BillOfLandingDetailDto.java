package com.ingeneo.scalingguacamole.dtos.responses;

import lombok.*;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Date;

@Getter
@AllArgsConstructor
@Builder
public class BillOfLandingDetailDto {
    private String fleetNumber;
    private String billOfLandingNumber;
    private String id;
    private String productTypeId;
    private String productType;
    private String clientId;
    private String clientName;
    private String clientIdentificationNumber;
    private String shipmentPort;
    private BigDecimal price;
    private BigDecimal quantity;
    private BigDecimal priceWithDiscount;
    private Date estimatedDeliveryTime;
    private Date registeredAt;
}
