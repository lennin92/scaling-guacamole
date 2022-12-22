package com.ingeneo.scalingguacamole.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ClientDetailDto {
    private String id;
    private String clientsIdentificationNumber;
    private String clientsName;
}
