package com.example.produit;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitBDD extends MongoRepository<Produit, String> {
}
