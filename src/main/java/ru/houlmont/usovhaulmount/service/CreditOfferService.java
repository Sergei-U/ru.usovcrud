package ru.houlmont.usovhaulmount.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.houlmont.usovhaulmount.entity.Client;
import ru.houlmont.usovhaulmount.entity.Credit;
import ru.houlmont.usovhaulmount.entity.CreditOffer;
import ru.houlmont.usovhaulmount.entity.PaymentSchedule;
import ru.houlmont.usovhaulmount.repository.ClientRepository;
import ru.houlmont.usovhaulmount.repository.CreditOfferRepository;
import ru.houlmont.usovhaulmount.repository.CreditRepository;

import java.util.List;
import java.util.UUID;

/**
 *
 */
@Service
@RequiredArgsConstructor
public class CreditOfferService {

    private final CreditOfferRepository creditOfferRepository;
    private final CreditRepository creditRepository;
    private final ClientRepository clientRepository;


    /**
     *  Кредитное предложение
     * o Клиент
     * o Кредит
     * o Сумма кредита
     * o График платежей
     * ▪ Дата платежа
     * ▪ Сумма платежа
     * ▪ Сумма гашения тела кредита
     * ▪ Сумма гашения процентов
     * @param creditOfferId
     * @return
     */

    public void creditOfferPayment(UUID creditOfferId){
        CreditOffer oneCreditOffer = creditOfferRepository.getOne(creditOfferId);
        Client clientOfCreditOffer = clientRepository.getOne(oneCreditOffer.getClient().getId());
        Credit creditOfCreditOffer = creditRepository.getOne(oneCreditOffer.getCredit().getId());
        clientOfCreditOffer.getCreditClientList();
        oneCreditOffer.getPaymentSchedule();



        return;
    }
}