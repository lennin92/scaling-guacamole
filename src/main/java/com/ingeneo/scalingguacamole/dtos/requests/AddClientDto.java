package com.ingeneo.scalingguacamole.dtos.requests;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@Setter
public class AddClientDto {
    private String clientsIdentificationNumber;
    private String clientsName;
}
