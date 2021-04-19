package ru.houlmont.usovhaulmount.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.houlmont.usovhaulmount.service.ClientService;

/**
 *
 */
@RestController
@RequestMapping(value = "/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;
}
