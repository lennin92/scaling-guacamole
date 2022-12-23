package com.ingeneo.scalingguacamole.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
public class CreateBillOfLandingDto extends CreateDeliveryDto {
    private String fleetNumber;
    private String billOfLandingNumber;
    private String shipmentPort;
}
