package com.ingeneo.scalingguacamole.services;

import com.ingeneo.scalingguacamole.dtos.requests.AddClientDto;
import com.ingeneo.scalingguacamole.dtos.responses.ClientDetailDto;
import com.ingeneo.scalingguacamole.entities.Client;
import com.ingeneo.scalingguacamole.fakers.ClientFactory;
import com.ingeneo.scalingguacamole.repositories.ClientRepository;
import com.ingeneo.scalingguacamole.services.impl.ClientsService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ClientsServiceTest {

    @Test
    public void GetClientsList(){
        List<Client> clientList = new ClientFactory().Generate(10);
        ClientRepository repo = mock(ClientRepository.class);
        when(repo.findAll()).thenReturn(clientList);

        ClientsService service = new ClientsService(repo);
        List<ClientDetailDto> dtos = service.getClients();

        int randomNum = ThreadLocalRandom.current().nextInt(0, dtos.size());
        Client c = clientList.get(randomNum);
        ClientDetailDto d = dtos.get(randomNum);

        Assert.assertEquals(c.getId(), d.getId());
        Assert.assertEquals(c.getClientsName(), d.getName());
        Assert.assertEquals(c.getClientsIdentification(), d.getIdentificationNumber());
    }

    @Test
    public void CreateClient(){
        Client cl = new ClientFactory().Generate();
        ClientRepository repo = mock(ClientRepository.class);
        when(repo.save(any())).thenReturn(cl);

        ClientsService service = new ClientsService(repo);
        AddClientDto addDto = new AddClientDto();
        addDto.setName(cl.getClientsName());
        addDto.setIdentificationNumber(cl.getClientsIdentification());
        ClientDetailDto dto = service.createClient(addDto);

        Assert.assertEquals(cl.getId(), dto.getId());
        Assert.assertEquals(cl.getClientsName(), dto.getName());
        Assert.assertEquals(cl.getClientsIdentification(), dto.getIdentificationNumber());
    }
}
