package ru.houlmont.usovhaulmount.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.houlmont.usovhaulmount.entity.Client;
import ru.houlmont.usovhaulmount.entity.Credit;
import ru.houlmont.usovhaulmount.repository.CreditRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 *
 */
@Service
@RequiredArgsConstructor
public class CreditService {

    private final CreditRepository creditRepository;

    public void addCredit(Credit credit) {
        this.creditRepository.save(credit);
    }

    public Credit editCredit(Credit credit) {
        return this.creditRepository.save(credit);
    }

    public void deleteCredit(UUID id) {
        this.creditRepository.deleteById(id);
    }

    public List<Credit> allCredit() {
        return creditRepository.findAll();
    }

    public List<Credit> creditList () {
        List<Credit> credits = new ArrayList<>();
        creditRepository.findAll().forEach(credits::add);
        return credits;
    }



    /**
     * Формула расчета аннуитетного платежа
     * (А) представляет собой следующее соотношение: А=К*(П/(1+П)-М-1),
     * где К – сумма кредита, П – процентная ставка, М – количество месяцев
     * @param
     */

    public double creditPaymentInMonth(UUID id) {
        Optional<Credit> creditById = creditRepository.findById(id);
                double k = creditById.get().getCreditLimit();
        double p = creditById.get().getCreditRate();
        int m = creditById.get().getCreditValidity();
        double creditPayment = k * (p / (1 + p) - m - 1);
        return creditPayment;
    }

    public Credit getCredit(UUID id) {
        return creditRepository.getOne(id);
    }
}

