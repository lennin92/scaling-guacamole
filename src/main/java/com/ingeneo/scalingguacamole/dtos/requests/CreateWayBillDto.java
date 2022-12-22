package com.ingeneo.scalingguacamole.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateWayBillDto extends CreateDeliveryDto {
    private String trucksPlate;
    private String waybillNumber;
}
