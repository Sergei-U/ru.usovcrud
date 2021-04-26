package ru.houlmont.usovhaulmount.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.houlmont.usovhaulmount.entity.Credit;
import ru.houlmont.usovhaulmount.repository.CreditRepository;

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

    public void deleteCredit(String id) {
        this.creditRepository.deleteById(id);
    }


    /**
     * Формула расчета аннуитетного платежа
     * (А) представляет собой следующее соотношение: А=К*(П/(1+П)-М-1),
     * где К – сумма кредита, П – процентная ставка, М – количество месяцев
     * @param credit
     */

    public double creditPaymentInMonth(Credit credit) {
        double k = credit.getCreditLimit();
        double p = credit.getCreditRate();
        int m = credit.getCreditValidity();
        double creditPayment = k * (p / (1 + p) - m - 1);
        return creditPayment;
    }
}

