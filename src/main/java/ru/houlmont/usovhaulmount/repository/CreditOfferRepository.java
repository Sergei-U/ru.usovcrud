package ru.houlmont.usovhaulmount.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.houlmont.usovhaulmount.entity.CreditOffer;

import java.util.UUID;

/**
 *
 */
public interface CreditOfferRepository extends JpaRepository<CreditOffer, UUID> {


    @Override
    CreditOffer getOne(UUID uuid);
}
