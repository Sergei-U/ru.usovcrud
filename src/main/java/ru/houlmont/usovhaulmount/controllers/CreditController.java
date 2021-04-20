package ru.houlmont.usovhaulmount.controllers;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.houlmont.usovhaulmount.entity.Credit;
import ru.houlmont.usovhaulmount.service.CreditService;

/**
 *
 */
@RestController
@RequestMapping(value = "/credit")
@RequiredArgsConstructor
public class CreditController {

    private final CreditService creditService;

    @GetMapping("/editcredit/{id}")
    @ApiOperation(value = "edit credit")
    public void editCredit(@RequestBody Credit credit) {this.creditService.editCredit(credit);}

    @DeleteMapping("/deletecredit/{id}")
    @ApiOperation(value = "delete credit")
    public void deleteCredit(@RequestBody Credit credit) {this.creditService.deleteCredit(credit);}

    @GetMapping("/creditinmonth/{id}")
    @ApiOperation(value = "credit operation in month")
    public void creditPaymentInMonth(@RequestBody Credit credit) {this.creditService.creditPaymentInMonth(credit);}


    @GetMapping("/addnewcredit")
    @ApiOperation(value = "add new credit")
    public void addNewCredit(@RequestBody Credit credit) { this.creditService.addCredit(credit);}
}
