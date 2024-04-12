package com.example.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneCommandeBDD extends JpaRepository<LigneCommande, LigneCommandeId> {
}
