package com.example.Commande;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeBDD extends JpaRepository<Commande, Integer> {
}
