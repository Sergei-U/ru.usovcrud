package ru.houlmont.usovhaulmount.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.houlmont.usovhaulmount.entity.Client;
import ru.houlmont.usovhaulmount.repository.ClientRepository;

import java.util.ArrayList;
import java.util.List;

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

    public void deleteClient(String id) {
        this.clientRepository.deleteById(id);
    }

    public List<Client> allClient() {

        return clientRepository.findAll();
    }

    public List<Client> clientList() {
        List<Client> clients = new ArrayList<>();
        clientRepository.findAll().forEach(clients::add);
        return clients;
    }
}
