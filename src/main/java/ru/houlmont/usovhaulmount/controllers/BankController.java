package ru.houlmont.usovhaulmount.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.houlmont.usovhaulmount.entity.Bank;
import ru.houlmont.usovhaulmount.entity.Client;
import ru.houlmont.usovhaulmount.service.*;

/**
 *
 */
@RestController
@RequestMapping(value = "/")
@RequiredArgsConstructor
public class BankController {


    private final CreditService creditService;
    private final ClientService clientService;
    private final BankService bankService;

    public void addNewBank(@RequestBody Bank bank) { this.bankService.addBank(bank); }

    public void addClient(@RequestBody Client client) {this.clientService.addClient(client);}


}

