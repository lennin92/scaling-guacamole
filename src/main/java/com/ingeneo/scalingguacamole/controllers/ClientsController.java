package com.ingeneo.scalingguacamole.controllers;

import com.ingeneo.scalingguacamole.dtos.responses.ClientDetailDto;
import com.ingeneo.scalingguacamole.services.IClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientsController {
    private IClientsService service;

    public ClientsController(@Autowired IClientsService service) {
        this.service = service;
    }

    @GetMapping
    public List<ClientDetailDto> getClientsList(){
        return this.service.getClients();
    }

    @PostMapping
    public ClientDetailDto createClient(@RequestBody CreateCl)
}
