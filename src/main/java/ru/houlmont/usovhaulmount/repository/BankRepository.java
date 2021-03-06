package ru.houlmont.usovhaulmount.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.houlmont.usovhaulmount.entity.Bank;

import java.util.UUID;

/**
 *
 */
@Repository
public interface BankRepository extends JpaRepository<Bank, UUID> {

}
