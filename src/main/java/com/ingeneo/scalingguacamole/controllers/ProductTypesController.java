package com.ingeneo.scalingguacamole.controllers;


import com.ingeneo.scalingguacamole.dtos.responses.ProductTypeDetailDto;
import com.ingeneo.scalingguacamole.services.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product_types")
public class ProductTypesController {
    private final IProductTypeService service;

    public ProductTypesController(
            @Autowired IProductTypeService service
    ) {
        this.service = service;
    }

    @GetMapping
    public List<ProductTypeDetailDto> getProductTypes(){
        return this.service.getProductTypes();
    }
}

