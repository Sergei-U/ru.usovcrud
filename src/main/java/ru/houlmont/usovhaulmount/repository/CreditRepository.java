package ru.houlmont.usovhaulmount.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.houlmont.usovhaulmount.entity.Credit;

import java.util.Optional;
import java.util.UUID;

/**
 *
 */
@Repository
public interface CreditRepository extends JpaRepository<Credit, UUID> {

    @Override
    Optional<Credit> findById(UUID uuid);
}
