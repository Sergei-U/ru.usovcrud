package ru.houlmont.usovhaulmount.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.houlmont.usovhaulmount.entity.Credit;

import java.util.List;
import java.util.Optional;

/**
 *
 */
@Repository
public interface CreditRepository extends JpaRepository<Credit, String> {

    @Override
    Optional<Credit> findById(String id);

    @Override
    List<Credit> findAll();
}
