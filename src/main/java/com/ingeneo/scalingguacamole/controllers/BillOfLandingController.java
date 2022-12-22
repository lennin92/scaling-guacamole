package com.ingeneo.scalingguacamole.controllers;

import com.ingeneo.scalingguacamole.dtos.requests.CreateBillOfLandingDto;
import com.ingeneo.scalingguacamole.dtos.requests.CreateWayBillDto;
import com.ingeneo.scalingguacamole.dtos.responses.BillOfLandingDetailDto;
import com.ingeneo.scalingguacamole.dtos.responses.WaybillDetailDto;
import com.ingeneo.scalingguacamole.services.IBillOfLandingService;
import com.ingeneo.scalingguacamole.services.IWayBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bill_of_landing")
public class BillOfLandingController {
    private final IBillOfLandingService service;

    public BillOfLandingController(@Autowired IBillOfLandingService service) {
        this.service = service;
    }

    @GetMapping
    public List<BillOfLandingDetailDto> getWaybillFilteded(
            @RequestParam(value = "clientId", defaultValue = "") String clientId,
            @RequestParam(value = "productTypeId", defaultValue = "") String productTypeId,
            @RequestParam(value = "trucksPlate", defaultValue = "") String trucksPlate,
            @RequestParam(value = "waybillNumber", defaultValue = "") String waybillNumber
    ){
        return this.service.getAllByCriteria(clientId, productTypeId, trucksPlate, waybillNumber);
    }

    @PostMapping
    public BillOfLandingDetailDto createWaybill(CreateBillOfLandingDto bdy){
        return this.service.createBillOfLanding(bdy);
    }
}
