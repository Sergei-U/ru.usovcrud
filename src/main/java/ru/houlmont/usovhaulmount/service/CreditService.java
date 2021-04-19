package ru.houlmont.usovhaulmount.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.jvnet.hk2.annotations.Service;
import ru.houlmont.usovhaulmount.entity.Client;
import ru.houlmont.usovhaulmount.entity.Credit;
import ru.houlmont.usovhaulmount.repository.CreditRepository;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;
import javax.persistence.Embedded;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
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

    public void editCredit(Credit credit) {
        this.creditRepository.save(credit);
    }

    public void deleteCredit(Credit credit) {
        this.creditRepository.delete(credit);
    }


    public double creditPaymentInMonth(Credit credit) {
        /**
         * Формула расчета аннуитетного платежа
         * (А) представляет собой следующее соотношение: А=К*(П/(1+П)-М-1),
         * где К – сумма кредита, П – процентная ставка, М – количество месяцев
         */
        double k = credit.getCreditLimit();
        double p = credit.getCreditRate();
        int m = credit.getCreditValidity();
        double creditPayment = k * (p / (1 + p) - m - 1);
        return creditPayment;
    }

    /**
     * Кредитное предложение
     * o Клиент
     * o Кредит
     * o Сумма кредита
     * o График платежей
     * ▪ Дата платежа
     * ▪ Сумма платежа
     * ▪ Сумма гашения тела кредит
     * ▪ Сумма гашения процентов
     *
     * @param credit
     * @return
     */

    public Credit creditPaymentSchedule(Credit credit) {
        return credit;
    }
}

