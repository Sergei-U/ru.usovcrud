package ru.houlmont.usovhaulmount.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.houlmont.usovhaulmount.entity.Bank;
import ru.houlmont.usovhaulmount.repository.BankRepository;

import java.util.UUID;

/**
 *
 */
@Service
@RequiredArgsConstructor
public class BankService {

    private final BankRepository bankRepository;

    public void addBank(Bank bank) {
        this.bankRepository.save(bank);
    }

    public void editBank(Bank bank) {
        this.bankRepository.save(bank);
    }

    public Bank getBank(UUID uuid) {
        return this.bankRepository.findById(uuid).get();
    }

    public void deleteBank(Bank bank) {
        this.bankRepository.delete(bank);
    }
}
