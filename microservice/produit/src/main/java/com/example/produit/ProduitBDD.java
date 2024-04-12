package com.example.produit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitBDD extends JpaRepository<Produit, Integer> {  // Notez l'utilisation de Long au lieu de String
}
