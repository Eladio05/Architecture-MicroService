package com.example.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaiementBDD extends JpaRepository<Paiement, Integer> {
    List<Paiement> findByIdCommande(int idCommande);
}
