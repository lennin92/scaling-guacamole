package com.ingeneo.scalingguacamole.services.impl;

import com.ingeneo.scalingguacamole.dtos.requests.CreateBillOfLandingDto;
import com.ingeneo.scalingguacamole.dtos.responses.BillOfLandingDetailDto;
import com.ingeneo.scalingguacamole.entities.BillOfLanding;
import com.ingeneo.scalingguacamole.entities.Client;
import com.ingeneo.scalingguacamole.entities.Delivery;
import com.ingeneo.scalingguacamole.entities.ProductType;
import com.ingeneo.scalingguacamole.repositories.BillOfLandingRepository;
import com.ingeneo.scalingguacamole.repositories.ClientRepository;
import com.ingeneo.scalingguacamole.repositories.DeliveryRepository;
import com.ingeneo.scalingguacamole.repositories.ProductTypeRepository;
import com.ingeneo.scalingguacamole.services.IBillOfLandingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BillOfLandingService implements IBillOfLandingService {
    private BillOfLandingRepository repository;
    private DeliveryRepository deliveryRepository;
    private ClientRepository clientRepository;
    private ProductTypeRepository productTypeRepository;

    public BillOfLandingService(
            @Autowired BillOfLandingRepository repository,
            @Autowired DeliveryRepository deliveryRepository,
            @Autowired ClientRepository clientRepository,
            @Autowired ProductTypeRepository productTypeRepository) {
        this.repository = repository;
        this.deliveryRepository = deliveryRepository;
        this.clientRepository = clientRepository;
        this.productTypeRepository = productTypeRepository;
    }

    public List<BillOfLandingDetailDto> getAllByCriteria(
            String clientName
    ){
        return this.repository.findAllByDelivery_ClientId(clientName)
                .stream()
                .map(billOfLanding -> this.createDetailDtoFromEntity(billOfLanding))
                .toList();
    }

    public BillOfLandingDetailDto createBillOfLanding(CreateBillOfLandingDto bdy){
        Optional<Client> oc = this.clientRepository.findById(bdy.getClientId());
        if (oc.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Client doesn't exists");
        }
        Optional<ProductType> ptc = this.productTypeRepository.findById(bdy.getProductTypeId());
        if (ptc.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Prudct type doesn't exists");
        }
        BigDecimal priceWithDiscount = bdy.getProductQuantity().compareTo(BigDecimal.valueOf(10)) <= 0 ?
                bdy.getPrice() : bdy.getPrice().multiply(BigDecimal.valueOf(0.97));
        Delivery d = Delivery.builder()
                .client(oc.get())
                .productType(ptc.get())
                .deliveryPrice(bdy.getPrice())
                .registeredAt(new Date())
                .estimatedDeliveryDate(bdy.getEstimatedDeliveryTime())
                .productQuantity(bdy.getProductQuantity())
                .priceWithDiscount(priceWithDiscount)
                .build();
        d = this.deliveryRepository.save(d);
        BillOfLanding bl = BillOfLanding.builder()
                .billOfLandingNumber(bdy.getBillOfLandingNumber())
                .shipmentPort(bdy.getShipmentPort())
                .fleetNumber(bdy.getFleetNumber())
                .delivery(d)
                .build();
        return this.createDetailDtoFromEntity(this.repository.save(bl));
    }

    private BillOfLandingDetailDto createDetailDtoFromEntity(BillOfLanding bl){
        Delivery de = bl.getDelivery();
        Client cl  = de.getClient();
        ProductType pt = de.getProductType();
        return BillOfLandingDetailDto.builder()
                .billOfLandingNumber(bl.getBillOfLandingNumber())
                .fleetNumber(bl.getFleetNumber())
                .shipmentPort(bl.getShipmentPort())
                .price(de.getDeliveryPrice())
                .productType(pt.getProductTypeName())
                .productTypeId(pt.getId())
                .clientIdentificationNumber(cl.getClientsIdentification())
                .clientName(cl.getClientsName())
                .clientId(cl.getId())
                .id(bl.getId())
                .estimatedDeliveryTime(bl.getDelivery().getEstimatedDeliveryDate())
                .registeredAt(bl.getDelivery().getRegisteredAt())
                .priceWithDiscount(bl.getDelivery().getPriceWithDiscount())
                .quantity(bl.getDelivery().getProductQuantity())
                .build();
    }
}
