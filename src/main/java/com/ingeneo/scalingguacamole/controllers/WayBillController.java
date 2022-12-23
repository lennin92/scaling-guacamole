package com.ingeneo.scalingguacamole.controllers;

import com.ingeneo.scalingguacamole.dtos.requests.CreateWayBillDto;
import com.ingeneo.scalingguacamole.dtos.responses.WaybillDetailDto;
import com.ingeneo.scalingguacamole.services.IWayBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/waybill")
public class WayBillController {
    private final IWayBillService service;

    public WayBillController(@Autowired IWayBillService service) {
        this.service = service;
    }

    @GetMapping
    public List<WaybillDetailDto> getWaybillFilteded(
            @RequestParam(value = "clientId", defaultValue = "") String clientName
    ){
        return this.service.getAllByCriteria(clientName.toLowerCase());
    }

    @PostMapping
    public WaybillDetailDto createWaybill(
            @RequestBody CreateWayBillDto bdy){
        return this.service.createWayBill(bdy);
    }
}
