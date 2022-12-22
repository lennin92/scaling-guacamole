package com.ingeneo.scalingguacamole.dtos.responses;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WaybillDetailDto extends DeliveryDetailDto {
    private String trucksPlate;
    private String waybillNumber;
}
