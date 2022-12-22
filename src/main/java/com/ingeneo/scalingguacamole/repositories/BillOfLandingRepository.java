package com.ingeneo.scalingguacamole.repositories;

import com.ingeneo.scalingguacamole.entities.BillOfLanding;
import com.ingeneo.scalingguacamole.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillOfLandingRepository
        extends JpaRepository<BillOfLanding, String> {
    List<BillOfLanding> findAllByDelivery_Client(Client client);
}
