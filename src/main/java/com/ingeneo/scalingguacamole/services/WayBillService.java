package com.ingeneo.scalingguacamole.services;

import com.ingeneo.scalingguacamole.dtos.requests.CreateWayBillDto;
import com.ingeneo.scalingguacamole.dtos.responses.WaybillDetailDto;
import com.ingeneo.scalingguacamole.entities.*;
import com.ingeneo.scalingguacamole.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class WayBillService implements IWayBillService{
    private WayBillRepository repository;
    private DeliveryRepository deliveryRepository;
    private ClientRepository clientRepository;
    private ProductTypeRepository productTypeRepository;

    public WayBillService(
            @Autowired WayBillRepository repository,
            @Autowired DeliveryRepository deliveryRepository,
            @Autowired ClientRepository clientRepository,
            @Autowired ProductTypeRepository productTypeRepository) {
        this.repository = repository;
        this.deliveryRepository = deliveryRepository;
        this.clientRepository = clientRepository;
        this.productTypeRepository = productTypeRepository;
    }

    public List<WaybillDetailDto> getAllByCriteria(
            String clientName
    ){
        return this.repository.findAllByDelivery_Client_ClientsNameIsContaining(clientName)
                .stream()
                .map(billOfLanding -> this.createDetailDtoFromEntity(billOfLanding))
                .toList();
    }

    @Override
    public WaybillDetailDto createWayBill(CreateWayBillDto bdy) {
        Optional<Client> oc = this.clientRepository.findById(bdy.getClientId());
        if (oc.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Client doesn't exists");
        }
        Optional<ProductType> ptc = this.productTypeRepository.findById(bdy.getProductTypeId());
        if (ptc.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Prudct type doesn't exists");
        }
        BigDecimal priceWithDiscount = bdy.getProductQuantity().compareTo(BigDecimal.valueOf(10)) <= 0 ?
                bdy.getPrice() : bdy.getPrice().multiply(BigDecimal.valueOf(0.95));
        Delivery d = Delivery.builder()
                .client(oc.get())
                .productType(ptc.get())
                .deliveryPrice(bdy.getPrice())
                .registeredAt(ZonedDateTime.now())
                .estimatedDeliveryDate(bdy.getEstimatedDeliveryTime())
                .productQuantity(bdy.getProductQuantity())
                .priceWithDiscount(priceWithDiscount)
                .build();
        d = this.deliveryRepository.save(d);
        WayBill bl = WayBill.builder()
                .waybillNumber(bdy.getWaybillNumber())
                .warehouse(bdy.getWarehouse())
                .trucksPlate(bdy.getTrucksPlate())
                .delivery(d)
                .build();
        return this.createDetailDtoFromEntity(this.repository.save(bl));
    }

    private WaybillDetailDto createDetailDtoFromEntity(WayBill bl){
        Delivery de = bl.getDelivery();
        Client cl  = de.getClient();
        ProductType pt = de.getProductType();
        return WaybillDetailDto.builder()
                .waybillNumber(bl.getWaybillNumber())
                .trucksPlate(bl.getTrucksPlate())
                .warehouse(bl.getWarehouse())
                .price(de.getDeliveryPrice())
                .productType(pt.getProductTypeName())
                .productTypeId(pt.getId())
                .clientIdentificationNumber(cl.getClientsIdentification())
                .clientName(cl.getClientsName())
                .clientId(cl.getId())
                .estimatedDeliveryTime(bl.getDelivery().getEstimatedDeliveryDate())
                .registeredAt(bl.getDelivery().getRegisteredAt())
                .priceWithDiscount(bl.getDelivery().getPriceWithDiscount())
                .quantity(bl.getDelivery().getProductQuantity())
                .build();
    }
}
