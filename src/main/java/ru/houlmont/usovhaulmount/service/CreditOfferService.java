package ru.houlmont.usovhaulmount.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.houlmont.usovhaulmount.entity.Client;
import ru.houlmont.usovhaulmount.entity.Credit;
import ru.houlmont.usovhaulmount.entity.CreditOffer;
import ru.houlmont.usovhaulmount.repository.CreditOfferRepository;
import ru.houlmont.usovhaulmount.repository.CreditRepository;

import java.util.UUID;

/**
 *
 */
@Service
@RequiredArgsConstructor
public class CreditOfferService {

    private final CreditOfferRepository creditOfferRepository;
    private final CreditRepository creditRepository;


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
     * @param id
     * @return
     */

    public void creditOfferPayment(UUID id){
        Credit creditToOffer = creditRepository.getOne(id); // получили credit по credit id
        Client client = CreditOffer.getClient(); //получить клинта из creditOffer'a по id credita

        return;
    }
}
