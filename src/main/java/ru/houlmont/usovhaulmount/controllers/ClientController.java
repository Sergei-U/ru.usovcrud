package ru.houlmont.usovhaulmount.controllers;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.houlmont.usovhaulmount.entity.Client;
import ru.houlmont.usovhaulmount.entity.Credit;
import ru.houlmont.usovhaulmount.service.ClientService;

import java.util.Date;
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


    @RequestMapping("/delete/{id}")
    @ApiOperation(value = "delete client")
    public ModelAndView deleteClient(@PathVariable("id") UUID id, Map<String, Object> model) {
        clientService.deleteClient(id);
        return clientList(model);
    }


    @GetMapping("/clients")
    public List<Client> clients() {
        return clientService.clientList();
    }


    @GetMapping
    public ModelAndView clientList(Map<String, Object> model) {
        List<Client> clients = clientService.allClient();
        model.put("client", clients);
        return new ModelAndView("client", model);
    }

    @PostMapping
    public ModelAndView add(@RequestParam String firstName,
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
        return new ModelAndView("client", model);
    }

    @RequestMapping("/clientupdate/{id}")
    public ModelAndView update(@PathVariable("id") UUID id,
                               @RequestParam String firstName,
                               @RequestParam String lastName,
                               @RequestParam String thirdName,
                               @RequestParam Long telephoneNumber,
                               @RequestParam String email,
                               @RequestParam int serialPassport,
                               @RequestParam Long numberPassport,
                               Map<String, Object> model) {
        Client client = clientService.getClient(id);
        Client updateClient = new Client(
                firstName,
                lastName,
                thirdName,
                telephoneNumber,
                email,
                serialPassport,
                numberPassport);
        clientService.editClient(updateClient);
        model.put("clientupdate", client);
        model.put("isUpdate", true);
        return new ModelAndView("clientupdate", model);
    }

    @RequestMapping("/addcredittoclient/{id}")
    public ModelAndView addCreditToClient(@PathVariable("id") UUID id,
                                          @RequestParam String creditName,
                                          @RequestParam int creditLimit,
                                          @RequestParam int creditValidity,
                                          @RequestParam double creditRate,
                                          @RequestParam Date creditStartDate,
                                          Map<String, Object> model) {
        Client client = clientService.getClient(id);
        Credit newCredit = new Credit(
                creditName,
                creditLimit,
                creditValidity,
                creditRate,
                creditStartDate);
        client.getCreditClientList().add(newCredit);
        model.put("addcredittoclient", client);
        return new ModelAndView("addcredittoclient", model);
    }
}

