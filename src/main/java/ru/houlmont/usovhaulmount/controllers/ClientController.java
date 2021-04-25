package ru.houlmont.usovhaulmount.controllers;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.houlmont.usovhaulmount.entity.Client;
import ru.houlmont.usovhaulmount.service.ClientService;

import java.util.List;

/**
 *
 */
@RestController
@RequestMapping(value = "/client")
@RequiredArgsConstructor
public class ClientController {

    @Autowired
    private final ClientService clientService;

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    @ApiOperation(value = "add new client")
    public void addClient(@RequestBody Client client) {
        this.clientService.addClient(client);
    }

    @GetMapping("/edit/{id}")
    @ApiOperation(value = "edit client")
    public void editClient(@RequestBody Client client) {
        this.clientService.editClient(client);
    }

    @DeleteMapping("/deleteclient/{id}")
    @ApiOperation(value = "delete client")
    public void deleteClient(@PathVariable String id) {
        this.clientService.deleteClient(id);
    }

    @GetMapping("/clients")
    public List<Client> clients() {
        return clientService.clientList(); }


}

