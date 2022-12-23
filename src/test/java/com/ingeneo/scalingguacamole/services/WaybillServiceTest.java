package com.ingeneo.scalingguacamole.services;

import com.ingeneo.scalingguacamole.dtos.requests.CreateBillOfLandingDto;
import com.ingeneo.scalingguacamole.dtos.requests.CreateWayBillDto;
import com.ingeneo.scalingguacamole.dtos.responses.BillOfLandingDetailDto;
import com.ingeneo.scalingguacamole.dtos.responses.WaybillDetailDto;
import com.ingeneo.scalingguacamole.entities.BillOfLanding;
import com.ingeneo.scalingguacamole.entities.Client;
import com.ingeneo.scalingguacamole.entities.WayBill;
import com.ingeneo.scalingguacamole.fakers.BillOfLandingFactory;
import com.ingeneo.scalingguacamole.fakers.ClientFactory;
import com.ingeneo.scalingguacamole.fakers.WaybillFactory;
import com.ingeneo.scalingguacamole.repositories.*;
import com.ingeneo.scalingguacamole.services.impl.WayBillService;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import static org.mockito.Mockito.*;

public class WaybillServiceTest {
    @Test
    public void shouldListAllBols(){
        Client c = new ClientFactory().Generate();
        List<WayBill> bol_list = new WaybillFactory().Generate(10);
        bol_list.stream().forEach(t -> t.getDelivery().setClient(c));

        WayBillRepository repo = mock(WayBillRepository.class);
        when(repo.findAllByDelivery_ClientId(anyString())).thenReturn(bol_list);

        WayBillService service = new WayBillService(repo,
                mock(DeliveryRepository.class),
                mock(ClientRepository.class),
                mock(ProductTypeRepository.class));
        List<WaybillDetailDto> returns = service.getAllByCriteria(c.getClientsName());
        Assert.assertEquals(returns.size(), bol_list.size());

        int randomNum = ThreadLocalRandom.current().nextInt(0, returns.size());
        WayBill bol = bol_list.get(randomNum);
        WaybillDetailDto dto = returns.get(randomNum);

        Assert.assertEquals(bol.getId(), dto.getId());
        Assert.assertEquals(bol.getDelivery().getClient().getId(), dto.getClientId());
        Assert.assertEquals(bol.getDelivery().getProductType().getId(), dto.getProductTypeId());
    }

    @Test
    public void shouldCreateBol(){
        WayBill bl = new WaybillFactory().Generate();

        WayBillRepository repo = mock(WayBillRepository.class);
        when(repo.save(any())).thenReturn(bl);
        DeliveryRepository devRepo = mock(DeliveryRepository.class);
        ClientRepository clieRepo = mock(ClientRepository.class);
        ProductTypeRepository prodTRepo = mock(ProductTypeRepository.class);

        WayBillService service = new WayBillService(repo, devRepo, clieRepo, prodTRepo);
        CreateWayBillDto inputDto = new CreateWayBillDto();
        inputDto.setPrice(bl.getDelivery().getDeliveryPrice());
        inputDto.setWaybillNumber(bl.getWaybillNumber());
        inputDto.setTrucksPlate(bl.getTrucksPlate());
        inputDto.setClientId(bl.getDelivery().getClient().getId());
        inputDto.setProductTypeId(bl.getDelivery().getProductType().getId());
        inputDto.setProductQuantity(bl.getDelivery().getProductQuantity());
        inputDto.setPrice(bl.getDelivery().getDeliveryPrice());
        inputDto.setWarehouse(bl.getWarehouse());
        inputDto.setEstimatedDeliveryTime(bl.getDelivery().getEstimatedDeliveryDate());
        when(clieRepo.findById(anyString())).thenReturn(Optional.of(bl.getDelivery().getClient()));
        when(prodTRepo.findById(anyString())).thenReturn(Optional.of(bl.getDelivery().getProductType()));

        WaybillDetailDto dto = service.createWayBill(inputDto);


        Assert.assertEquals(dto.getClientId(), bl.getDelivery().getClient().getId());
        Assert.assertEquals(dto.getClientName(), bl.getDelivery().getClient().getClientsName());
        Assert.assertEquals(dto.getProductTypeId(), bl.getDelivery().getProductType().getId());
        Assert.assertEquals(dto.getProductType(), bl.getDelivery().getProductType().getProductTypeName());
    }
}
