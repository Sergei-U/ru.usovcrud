package ru.houlmont.usovhaulmount.service;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import ru.houlmont.usovhaulmount.entity.Client;
import ru.houlmont.usovhaulmount.repository.ClientRepository;

import java.util.UUID;

/**
 *
 */
@Service
@RequiredArgsConstructor
public class ClientService {


    private final ClientRepository clientRepository;


    public void addClient(Client client) {
        this.clientRepository.save(client);
    }

    public void editClient(Client client) {
        this.clientRepository.save(client);
    }

    public void deleteClient(Client client) {
        this.clientRepository.delete(client);
    }
}
