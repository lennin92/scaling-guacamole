package com.ingeneo.scalingguacamole.dtos.responses;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientDetailDto {
    private String id;
    private String identificationNumber;
    private String name;
}
