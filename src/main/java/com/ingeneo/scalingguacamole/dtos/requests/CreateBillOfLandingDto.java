package com.ingeneo.scalingguacamole.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateBillOfLandingDto extends CreateDeliveryDto {
    private String fleetNumber;
    private String billOfLandingNumber;
}
