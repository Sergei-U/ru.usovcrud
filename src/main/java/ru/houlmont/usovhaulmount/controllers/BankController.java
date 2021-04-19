package ru.houlmont.usovhaulmount.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.houlmont.usovhaulmount.service.BankService;

/**
 *
 */
@RestController
@RequestMapping(value = "/bank")
@RequiredArgsConstructor
public class BankController {

    private final BankService bankService;
}
