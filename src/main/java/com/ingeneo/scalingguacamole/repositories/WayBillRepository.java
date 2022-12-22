package com.ingeneo.scalingguacamole.repositories;

import com.ingeneo.scalingguacamole.entities.Client;
import com.ingeneo.scalingguacamole.entities.WayBill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WayBillRepository
        extends JpaRepository<WayBill, String> {

    List<WayBill> findAllByDelivery_Client(Client client);
}
