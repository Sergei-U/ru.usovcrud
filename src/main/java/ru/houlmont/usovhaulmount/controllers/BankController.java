package ru.houlmont.usovhaulmount.controllers;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.houlmont.usovhaulmount.entity.Bank;
import ru.houlmont.usovhaulmount.service.BankService;

import java.util.UUID;


/**
 *
 */
@RestController
@RequestMapping(value = "bank")
@RequiredArgsConstructor
public class BankController {

    private final BankService bankService;


    @RequestMapping("/")
    public void indexBank(){

    }

    @PostMapping("/add")
    @ApiOperation(value = "Добавление нового банка")
    public void addNewBank(@RequestBody Bank bank) {
        this.bankService.addBank(bank);
    }

    @PostMapping("/edit/{id}")
    @ApiOperation(value = "edit bank")
    public void editBank(@RequestBody Bank bank) {
        this.bankService.editBank(bank);
    }

    @GetMapping("/get/{id}")
    @ApiOperation(value = "Получение банка по ID")
    public Bank getBank(@PathVariable(value = "id") UUID uuid) {
        return bankService.getBank(uuid);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "delete bank")
    public void deleteBank(@RequestBody Bank bank) {
        this.bankService.deleteBank(bank);
    }

}

