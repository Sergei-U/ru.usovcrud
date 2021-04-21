package ru.houlmont.usovhaulmount.controllers;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.houlmont.usovhaulmount.entity.Client;
import ru.houlmont.usovhaulmount.service.ClientService;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 *
 */
@RestController
@RequestMapping(value = "/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping("/add")
    @ApiOperation(value = "add new client")
    public void addClient(@RequestBody Client client) {this.clientService.addClient(client);}

    @GetMapping("/editclient/{id}")
    @ApiOperation(value = "edit client")
    public void editClient(@RequestBody Client client) { this.clientService.editClient(client);}

    @DeleteMapping("/deleteclient/{id}")
    @ApiOperation(value = "delete client")
    public void deleteClient(@RequestBody Client client) {this.clientService.deleteClient(client);}

    @GetMapping("/clients")
    public List<Client> clients() {
        return Arrays.asList(
                new Client(UUID.randomUUID()),
                new Client(UUID.randomUUID()),
                new Client(UUID.randomUUID()),
                new Client(UUID.randomUUID()),
                new Client(UUID.randomUUID()),
                new Client(UUID.randomUUID()),
                new Client(UUID.randomUUID())
        );
    }

}

