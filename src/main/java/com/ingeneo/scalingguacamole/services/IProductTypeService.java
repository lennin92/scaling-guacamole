package com.ingeneo.scalingguacamole.services;

import com.ingeneo.scalingguacamole.dtos.responses.ProductTypeDetailDto;

import java.util.List;


public interface IProductTypeService {
    List<ProductTypeDetailDto> getProductTypes();
}
