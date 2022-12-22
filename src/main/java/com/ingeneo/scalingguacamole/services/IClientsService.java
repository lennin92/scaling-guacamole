package com.ingeneo.scalingguacamole.services;

import com.ingeneo.scalingguacamole.dtos.responses.ClientDetailDto;

import java.util.List;

public interface IClientsService {
    List<ClientDetailDto> getClients();
}
