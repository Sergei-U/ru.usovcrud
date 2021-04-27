package ru.houlmont.usovhaulmount.controllers;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.houlmont.usovhaulmount.entity.Client;
import ru.houlmont.usovhaulmount.service.ClientService;

import java.util.List;
import java.util.Map;
import java.util.UUID;

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

    @RequestMapping("/delete/{id}")
    @ApiOperation(value = "delete client")
    public ModelAndView deleteClient(@PathVariable("id") UUID id, Map<String, Object> model) {
        clientService.deleteClient(id);
        List<Client> clients = clientService.clientList();
        return new ModelAndView( "/client", model);
    }




    @GetMapping("/clients")
    public List<Client> clients() {
        return clientService.clientList(); }


    @GetMapping
    public ModelAndView clientList (Map<String, Object> model) {
        List<Client> clients = clientService.allClient();
        model.put("client", clients);
        return new ModelAndView("client", model);
    }

    @PostMapping
    public ModelAndView add(
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String thirdName,
            @RequestParam Long telephoneNumber,
            @RequestParam String email,
            @RequestParam int serialPassport,
            @RequestParam Long numberPassport,
            Map<String, Object> model) {
        Client client = new Client(
                firstName,
                lastName,
                thirdName,
                telephoneNumber,
                email,
                serialPassport,
                numberPassport);
        clientService.addClient(client);
        List<Client> clients = clientService.clientList();
        model.put("client", clients);
        return new ModelAndView( "client", model);
    }

}

