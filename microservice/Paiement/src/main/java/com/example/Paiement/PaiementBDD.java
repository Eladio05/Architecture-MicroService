package com.example.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaiementBDD extends JpaRepository<Paiement, Integer> {
}
