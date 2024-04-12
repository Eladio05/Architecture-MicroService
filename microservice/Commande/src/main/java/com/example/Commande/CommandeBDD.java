package com.example.Commande;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeBDD extends MongoRepository<Commande, String> {
}
