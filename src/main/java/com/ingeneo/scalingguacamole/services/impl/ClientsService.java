package com.ingeneo.scalingguacamole.services.impl;

import com.ingeneo.scalingguacamole.dtos.requests.AddClientDto;
import com.ingeneo.scalingguacamole.dtos.responses.ClientDetailDto;
import com.ingeneo.scalingguacamole.entities.Client;
import com.ingeneo.scalingguacamole.repositories.ClientRepository;
import com.ingeneo.scalingguacamole.services.IClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientsService implements IClientsService {
    private ClientRepository repository;

    public ClientsService(@Autowired ClientRepository repository) {
        this.repository = repository;
    }

    public List<ClientDetailDto> getClients(){
        return this.repository.findAll().stream()
                .map(client -> this.generateDetailDtoFromClient(client))
                .toList();
    }

    @Override
    public ClientDetailDto createClient(AddClientDto newClient) {
        Client c = this.repository.save(Client.builder()
                        .clientsIdentification(newClient.getIdentificationNumber())
                        .clientsName(newClient.getName())
                .build());
        return this.generateDetailDtoFromClient(c);
    }

    private ClientDetailDto generateDetailDtoFromClient(Client client){
        return ClientDetailDto.builder()
                .name(client.getClientsName())
                .id(client.getId())
                .identificationNumber(client.getClientsIdentification())
                .build();
    }
}
