package com.ingeneo.scalingguacamole.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddClientDto {
    private String identificationNumber;
    private String name;
}
