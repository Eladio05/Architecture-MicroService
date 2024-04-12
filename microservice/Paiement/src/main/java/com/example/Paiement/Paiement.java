package com.example.Paiement;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "paiements")
public class Paiement {
    @Id
    private String id;

}

