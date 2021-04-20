package ru.houlmont.usovhaulmount.controllers;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.houlmont.usovhaulmount.entity.Client;
import ru.houlmont.usovhaulmount.service.ClientService;

/**
 *
 */
@RestController
@RequestMapping(value = "/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/addclient")
    @ApiOperation(value = "add new client")
    public void addClient(@RequestBody Client client) {this.clientService.addClient(client);}

    @GetMapping("/editclient/{id}")
    @ApiOperation(value = "edit client")
    public void editCLient(@RequestBody Client client) { this.clientService.editClient(client);}

    @DeleteMapping("/deleteclient/{id}")
    @ApiOperation(value = "delete client")
    public void deleteClient(@RequestBody Client client) {this.clientService.deleteClient(client);}

}
