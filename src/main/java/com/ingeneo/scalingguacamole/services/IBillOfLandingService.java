package com.ingeneo.scalingguacamole.services;

import com.ingeneo.scalingguacamole.dtos.requests.CreateBillOfLandingDto;
import com.ingeneo.scalingguacamole.dtos.responses.BillOfLandingDetailDto;

import java.util.List;

public interface IBillOfLandingService {
    List<BillOfLandingDetailDto> getAllByCriteria(
            String clientId,
            String productTypeId,
            String fleetNumber,
            String billOfLandingNumber
    );

    BillOfLandingDetailDto createBillOfLanding(CreateBillOfLandingDto bdy);
}
