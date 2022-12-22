package com.ingeneo.scalingguacamole.repositories;

import com.ingeneo.scalingguacamole.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository
        extends JpaRepository<Client, String> {

    Client findByClientsIdentification(String clientIdNumber);
}
