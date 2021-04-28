package ru.houlmont.usovhaulmount.controllers;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.houlmont.usovhaulmount.entity.Client;
import ru.houlmont.usovhaulmount.entity.Credit;
import ru.houlmont.usovhaulmount.entity.CreditOffer;
import ru.houlmont.usovhaulmount.service.CreditService;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
    public ModelAndView deleteCredit(@PathVariable("id") UUID id, Map<String, Object> model) {
        creditService.deleteCredit(id);
        return creditList(model);

    }

    @GetMapping("/creditinmonth/{id}")
    @ApiOperation(value = "credit operation in month")
    public void creditPaymentInMonth(@PathVariable("id") UUID id) {
        this.creditService.creditPaymentInMonth(id);
    }


    @GetMapping
    public ModelAndView creditList(Map<String, Object> model) {
        List<Credit> credits = creditService.allCredit();
        model.put("credit", credits);
        return new ModelAndView("credit", model);
    }

    @PostMapping
    public ModelAndView add(@RequestParam String creditName,
                            @RequestParam int creditLimit,
                            @RequestParam int creditValidity,
                            @RequestParam double creditRate,
                            @RequestParam Date creditStartDate,
                            Map<String, Object> model) {
        Credit credit = new Credit(
                creditName,
                creditLimit,
                creditValidity,
                creditRate,
                creditStartDate
        );
        creditService.addCredit(credit);
        List<Credit> credits = creditService.creditList();
        model.put("client", credits);
        return new ModelAndView("client", model);
    }

    @RequestMapping("/creditupdate/{id}")
    public ModelAndView update(@PathVariable("id") UUID id,
                               @RequestParam String creditName,
                               @RequestParam int creditLimit,
                               @RequestParam int creditValidity,
                               @RequestParam double creditRate,
                               @RequestParam Date creditStartDate,
                               Map<String, Object> model) {
        Credit credit = creditService.getCredit(id);
        Credit updateCredit = new Credit(
                creditName,
                creditLimit,
                creditValidity,
                creditRate,
                creditStartDate);
        creditService.editCredit(updateCredit);
        model.put("creditupdate", credit);
        model.put("isUpdate", true);
        return new ModelAndView("creditupdate", model);
    }


    @RequestMapping("/showcreditoffer/{id}")
    public ModelAndView showCreditOffer(@PathVariable("id") UUID id, Map<String, Object> model) {

        return null;
    }

}
