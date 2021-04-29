package ru.houlmont.usovhaulmount.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.houlmont.usovhaulmount.entity.Client;
import ru.houlmont.usovhaulmount.entity.CreditOffer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 *
 */
public interface CreditOfferRepository extends JpaRepository<CreditOffer, UUID> {


    @Override
    CreditOffer getOne(UUID uuid);


    Optional<List<CreditOffer>> findByClient(Client client);
}
