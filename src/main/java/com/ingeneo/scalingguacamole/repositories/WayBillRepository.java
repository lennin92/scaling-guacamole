package com.ingeneo.scalingguacamole.repositories;

import com.ingeneo.scalingguacamole.entities.WayBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WayBillRepository
        extends JpaRepository<WayBill, String> {

    List<WayBill> findAllByDelivery_Client_ClientsNameIsContaining(String name);
}
