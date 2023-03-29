package com.example.bankapp.controller;


import com.example.bankapp.dto.ClientDTO;
import com.example.bankapp.entity.Client;
import com.example.bankapp.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/client")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> showClients() {
        return clientService.getClients();
    }

    @GetMapping(path = "{findClient}")
 //   @ResponseStatus(HttpStatus.OK)
    public ClientDTO showClient(@PathVariable ("findClient") String name) {
        return clientService.findClientByName(name);
    }

}
