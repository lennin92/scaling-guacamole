package com.ingeneo.scalingguacamole.services;

import com.ingeneo.scalingguacamole.dtos.requests.CreateBillOfLandingDto;
import com.ingeneo.scalingguacamole.dtos.responses.BillOfLandingDetailDto;
import com.ingeneo.scalingguacamole.entities.BillOfLanding;
import com.ingeneo.scalingguacamole.entities.Client;
import com.ingeneo.scalingguacamole.fakers.BillOfLandingFactory;
import com.ingeneo.scalingguacamole.fakers.ClientFactory;
import com.ingeneo.scalingguacamole.repositories.BillOfLandingRepository;
import com.ingeneo.scalingguacamole.repositories.ClientRepository;
import com.ingeneo.scalingguacamole.repositories.DeliveryRepository;
import com.ingeneo.scalingguacamole.repositories.ProductTypeRepository;
import com.ingeneo.scalingguacamole.services.impl.BillOfLandingService;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import static org.mockito.Mockito.*;
public class BillOfLandingServiceTest {
    @Test
    public void shouldListAllBols(){
        Client c = new ClientFactory().Generate();
        List<BillOfLanding> bol_list = new BillOfLandingFactory().Generate(10);
        bol_list.stream().forEach(t -> t.getDelivery().setClient(c));

        BillOfLandingRepository repo = mock(BillOfLandingRepository.class);
        when(repo.findAllByDelivery_ClientId(anyString())).thenReturn(bol_list);

        BillOfLandingService service = new BillOfLandingService(repo,
                mock(DeliveryRepository.class),
                mock(ClientRepository.class),
                mock(ProductTypeRepository.class));
        List<BillOfLandingDetailDto> returns = service.getAllByCriteria(c.getClientsName());
        Assert.assertEquals(returns.size(), bol_list.size());

        int randomNum = ThreadLocalRandom.current().nextInt(0, returns.size());
        BillOfLanding bol = bol_list.get(randomNum);
        BillOfLandingDetailDto dto = returns.get(randomNum);

        Assert.assertEquals(bol.getId(), dto.getId());
        Assert.assertEquals(bol.getDelivery().getClient().getId(), dto.getClientId());
        Assert.assertEquals(bol.getDelivery().getProductType().getId(), dto.getProductTypeId());
    }

    @Test
    public void shouldCreateBol(){
        BillOfLanding bl = new BillOfLandingFactory().Generate();

        BillOfLandingRepository repo = mock(BillOfLandingRepository.class);
        when(repo.save(any())).thenReturn(bl);
        DeliveryRepository devRepo = mock(DeliveryRepository.class);
        ClientRepository clieRepo = mock(ClientRepository.class);
        ProductTypeRepository prodTRepo = mock(ProductTypeRepository.class);

        BillOfLandingService service = new BillOfLandingService(repo, devRepo, clieRepo, prodTRepo);
        CreateBillOfLandingDto inputDto = new CreateBillOfLandingDto();
        inputDto.setPrice(bl.getDelivery().getDeliveryPrice());
        inputDto.setBillOfLandingNumber(bl.getBillOfLandingNumber());
        inputDto.setFleetNumber(bl.getFleetNumber());
        inputDto.setClientId(bl.getDelivery().getClient().getId());
        inputDto.setProductTypeId(bl.getDelivery().getProductType().getId());
        inputDto.setProductQuantity(bl.getDelivery().getProductQuantity());
        inputDto.setPrice(bl.getDelivery().getDeliveryPrice());
        inputDto.setShipmentPort(bl.getShipmentPort());
        inputDto.setEstimatedDeliveryTime(bl.getDelivery().getEstimatedDeliveryDate());
        when(clieRepo.findById(anyString())).thenReturn(Optional.of(bl.getDelivery().getClient()));
        when(prodTRepo.findById(anyString())).thenReturn(Optional.of(bl.getDelivery().getProductType()));

        BillOfLandingDetailDto dto = service.createBillOfLanding(inputDto);


        Assert.assertEquals(dto.getClientId(), bl.getDelivery().getClient().getId());
        Assert.assertEquals(dto.getClientName(), bl.getDelivery().getClient().getClientsName());
        Assert.assertEquals(dto.getProductTypeId(), bl.getDelivery().getProductType().getId());
        Assert.assertEquals(dto.getProductType(), bl.getDelivery().getProductType().getProductTypeName());
        Assert.assertEquals(dto.getFleetNumber(), bl.getFleetNumber());
        Assert.assertEquals(dto.getBillOfLandingNumber(), bl.getBillOfLandingNumber());
        Assert.assertEquals(dto.getClientIdentificationNumber(), bl.getDelivery().getClient().getClientsIdentification());
        Assert.assertEquals(dto.getShipmentPort(), bl.getShipmentPort());
        Assert.assertEquals(dto.getPrice(), bl.getDelivery().getDeliveryPrice());
        Assert.assertEquals(dto.getQuantity(), bl.getDelivery().getProductQuantity());
        Assert.assertEquals(dto.getPriceWithDiscount(), bl.getDelivery().getPriceWithDiscount());

    }
}
