package com.ingeneo.scalingguacamole.services;

import com.ingeneo.scalingguacamole.dtos.requests.CreateWayBillDto;
import com.ingeneo.scalingguacamole.dtos.responses.WaybillDetailDto;

import java.util.List;

public interface IWayBillService {
    List<WaybillDetailDto> getAllByCriteria(
            String clientName
    );

    WaybillDetailDto createWayBill(CreateWayBillDto bdy);
}
