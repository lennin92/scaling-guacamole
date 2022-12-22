package com.ingeneo.scalingguacamole.services;

import com.ingeneo.scalingguacamole.dtos.requests.AddClientDto;
import com.ingeneo.scalingguacamole.dtos.responses.ClientDetailDto;
import com.ingeneo.scalingguacamole.entities.Client;
import com.ingeneo.scalingguacamole.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientsService implements IClientsService{
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
                        .clientsIdentification(newClient.getClientsIdentificationNumber())
                        .clientsName(newClient.getClientsName())
                .build());
        return this.generateDetailDtoFromClient(c);
    }

    private ClientDetailDto generateDetailDtoFromClient(Client client){
        return ClientDetailDto.builder()
                .clientsName(client.getClientsName())
                .id(client.getId())
                .clientsIdentificationNumber(client.getClientsIdentification())
                .build();
    }
}
