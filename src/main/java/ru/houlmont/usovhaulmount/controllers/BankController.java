package ru.houlmont.usovhaulmount.controllers;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.houlmont.usovhaulmount.entity.Bank;
import ru.houlmont.usovhaulmount.entity.Client;
import ru.houlmont.usovhaulmount.entity.Credit;
import ru.houlmont.usovhaulmount.service.CreditService;
import ru.houlmont.usovhaulmount.service.BankService;
import ru.houlmont.usovhaulmount.service.ClientService;


/**
 *
 */
@RestController
@RequestMapping(value = "/")
@RequiredArgsConstructor
public class BankController {

    private final CreditService creditService;
    private final BankService bankService;
    private final ClientService clientService;

    @GetMapping("/getnewbank")
    @ApiOperation(value = "add new bank")
    public void addNewBank(@RequestBody Bank bank) { this.bankService.addBank(bank); }

    @GetMapping("/editbank/{id}")
    @ApiOperation(value = "edit bank")
    public void editBank(@RequestBody Bank bank) { this.bankService.editBank(bank); }

    @DeleteMapping("/deletebank/{id}")
    @ApiOperation(value = "delete bank")
    public void deleteBank(@RequestBody Bank bank) { this.bankService.deleteBank(bank); }

    @GetMapping("/addclient")
    @ApiOperation(value = "add new client")
    public void addClient(@RequestBody Client client) {this.clientService.addClient(client);}

    @GetMapping("/editclient/{id}")
    @ApiOperation(value = "edit client")
    public void editCLient(@RequestBody Client client) { this.clientService.editClient(client);}

    @DeleteMapping("/deleteclient/{id}")
    @ApiOperation(value = "delete client")
    public void deleteClient(@RequestBody Client client) {this.clientService.deleteClient(client);}

    @GetMapping("/addnewcredit")
    @ApiOperation(value = "add new credit")
    public void addNewCredit(@RequestBody Credit credit) { this.creditService.addCredit(credit);}

    @GetMapping("/editcredit/{id}")
    @ApiOperation(value = "edit credit")
    public void editCredit(@RequestBody Credit credit) {this.creditService.editCredit(credit);}

    @DeleteMapping("/deletecredit/{id}")
    @ApiOperation(value = "delete credit")
    public void deleteCredit(@RequestBody Credit credit) {this.creditService.deleteCredit(credit);}

    @GetMapping("/creditinmonth/{id}")
    @ApiOperation(value = "credit operation in month")
    public void creditPaymentInMonth(@RequestBody Credit credit) {this.creditService.creditPaymentInMonth(credit);}
}

