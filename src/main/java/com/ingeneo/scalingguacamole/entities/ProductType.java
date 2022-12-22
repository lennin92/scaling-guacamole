package com.ingeneo.scalingguacamole.entities;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity(name = "product_type")
public class ProductType {
    private String id;
    private String productTypeName;
}
