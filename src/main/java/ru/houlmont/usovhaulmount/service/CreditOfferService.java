package ru.houlmont.usovhaulmount.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.houlmont.usovhaulmount.entity.Client;
import ru.houlmont.usovhaulmount.entity.CreditOffer;
import ru.houlmont.usovhaulmount.repository.ClientRepository;
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
     * @param
     * @return
     */

    public CreditOffer creditOfferPayment(UUID clientId){
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Клиент не найден"));
        return creditOfferRepository.findByClient(client).get().get(0);
    }
}

