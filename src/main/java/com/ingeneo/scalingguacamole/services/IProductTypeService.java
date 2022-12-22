package com.ingeneo.scalingguacamole.services;

import com.ingeneo.scalingguacamole.dtos.responses.ProductTypeDetailDto;
import com.ingeneo.scalingguacamole.repositories.ProductTypeRepository;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public interface IProductTypeService {
    List<ProductTypeDetailDto> getProductTypes();
}
