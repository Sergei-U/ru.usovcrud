package ru.houlmont.usovhaulmount.controllers;

import io.swagger.annotations.ApiModelProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.houlmont.usovhaulmount.service.CreditService;

/**
 *
 */
@RestController
@RequestMapping(value = "/credit")
@RequiredArgsConstructor
public class CreditController {

    private final CreditService creditService;

    @GetMapping("/addcredit")
    @ApiModelProperty(value = "добавление кредита")
    public void addCreditByID(){};





}
