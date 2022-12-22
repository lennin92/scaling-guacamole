package com.ingeneo.scalingguacamole.services;

import com.ingeneo.scalingguacamole.dtos.requests.CreateBillOfLandingDto;
import com.ingeneo.scalingguacamole.dtos.responses.BillOfLandingDetailDto;

import java.util.List;

public interface IBillOfLandingService {
    List<BillOfLandingDetailDto> getAllByCriteria(
            String clientName
    );

    BillOfLandingDetailDto createBillOfLanding(CreateBillOfLandingDto bdy);
}
