package com.example.client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientBDD extends JpaRepository<Client, Integer> {
    Optional<Client> findByIdentifiant(String identifiant);
}
