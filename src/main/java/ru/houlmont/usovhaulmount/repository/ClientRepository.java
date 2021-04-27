package ru.houlmont.usovhaulmount.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.houlmont.usovhaulmount.entity.Client;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 *
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, UUID> {

    @Override
    Optional<Client> findById(UUID id);



    @Override
    List<Client> findAll();

    @Override
    void deleteById(UUID s);
}
