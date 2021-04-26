package ru.houlmont.usovhaulmount.controllers;

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

    @RequestMapping("/addnewcredit")
    @ApiOperation(value = "add new credit")
    public void addNewCredit(@RequestBody Credit credit) {
        this.creditService.addCredit(credit);
    }

    @PostMapping("/edit/{id}")
    @ApiOperation(value = "edit credit")
    public Credit editCredit(@RequestBody Credit credit) {
        return this.creditService.editCredit(credit);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "delete credit")
    public void deleteCredit(@PathVariable String id) {
        this.creditService.deleteCredit(id);
    }

    @GetMapping("/creditinmonth/{id}")
    @ApiOperation(value = "credit operation in month")
    public void creditPaymentInMonth(@RequestBody Credit credit) {
        this.creditService.creditPaymentInMonth(credit);
    }
}
