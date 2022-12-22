package com.ingeneo.scalingguacamole.repositories;

import com.ingeneo.scalingguacamole.entities.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository
        extends JpaRepository<Delivery, String> {
}
