package com.ingeneo.scalingguacamole.repositories;

import com.ingeneo.scalingguacamole.entities.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductTypeRepository
        extends JpaRepository<ProductType, String> {
}
