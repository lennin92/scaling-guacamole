package com.ingeneo.scalingguacamole.services;

import com.ingeneo.scalingguacamole.dtos.responses.ProductTypeDetailDto;
import com.ingeneo.scalingguacamole.entities.ProductType;
import com.ingeneo.scalingguacamole.fakers.ProductTypeFactory;
import com.ingeneo.scalingguacamole.repositories.ProductTypeRepository;
import com.ingeneo.scalingguacamole.services.impl.ProductTypeService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProductTypeServiceTest {

    @Test
    public void GetClientsList(){
        List<ProductType> clientList = new ProductTypeFactory().Generate(10);
        ProductTypeRepository repo = mock(ProductTypeRepository.class);
        when(repo.findAll()).thenReturn(clientList);

        ProductTypeService service = new ProductTypeService(repo);
        List<ProductTypeDetailDto> dtos = service.getProductTypes();

        int randomNum = ThreadLocalRandom.current().nextInt(0, dtos.size());
        ProductType c = clientList.get(randomNum);
        ProductTypeDetailDto d = dtos.get(randomNum);

        Assert.assertEquals(c.getId(), d.getId());
        Assert.assertEquals(c.getProductTypeName(), d.getName());
    }
}
