package com.ingeneo.scalingguacamole.dtos.responses;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductTypeDetailDto {
    private String id;
    private String name;
}
