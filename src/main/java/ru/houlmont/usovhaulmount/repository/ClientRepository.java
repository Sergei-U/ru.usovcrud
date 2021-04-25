package ru.houlmont.usovhaulmount.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.houlmont.usovhaulmount.entity.Client;

import java.util.List;
import java.util.Optional;

/**
 *
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, String> {

    @Override
    Optional<Client> findById(String id);



    @Override
    List<Client> findAll();
}
