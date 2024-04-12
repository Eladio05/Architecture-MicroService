package com.example.client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientBDD extends MongoRepository<Client, String> {
}
