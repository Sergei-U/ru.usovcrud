package ru.houlmont.usovhaulmount.controllers;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.houlmont.usovhaulmount.entity.Bank;
import ru.houlmont.usovhaulmount.service.BankService;


/**
 *
 */
@RestController
@RequestMapping(value = "bank")
@RequiredArgsConstructor
public class BankController {

    private final BankService bankService;


    @GetMapping("/getnewbank")
    @ApiOperation(value = "add new bank")
    public void addNewBank(@RequestBody Bank bank) { this.bankService.addBank(bank); }

    @GetMapping("/editbank/{id}")
    @ApiOperation(value = "edit bank")
    public void editBank(@RequestBody Bank bank) { this.bankService.editBank(bank); }

    @DeleteMapping("/deletebank/{id}")
    @ApiOperation(value = "delete bank")
    public void deleteBank(@RequestBody Bank bank) { this.bankService.deleteBank(bank); }





}

