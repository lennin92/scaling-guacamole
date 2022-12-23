package com.ingeneo.scalingguacamole.services.impl;

import com.ingeneo.scalingguacamole.dtos.responses.ProductTypeDetailDto;
import com.ingeneo.scalingguacamole.repositories.ProductTypeRepository;
import com.ingeneo.scalingguacamole.services.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeService implements IProductTypeService {
    private ProductTypeRepository productTypeRepository;
    public ProductTypeService(
            @Autowired ProductTypeRepository productTypeRepository
    ) {
        this.productTypeRepository = productTypeRepository;
    }

    public List<ProductTypeDetailDto> getProductTypes(){
        return this.productTypeRepository.findAll().stream()
                .map(productType -> ProductTypeDetailDto.builder()
                        .id(productType.getId())
                        .name(productType.getProductTypeName())
                        .build())
                .toList();
    }
}
