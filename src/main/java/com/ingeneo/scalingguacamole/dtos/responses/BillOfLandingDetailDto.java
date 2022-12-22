package com.ingeneo.scalingguacamole.dtos.responses;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BillOfLandingDetailDto  extends DeliveryDetailDto {
    private String fleetNumber;
    private String billOfLandingNumber;
}
