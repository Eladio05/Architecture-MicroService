package com.example.produit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Arrays;

@RestController
public class GetProduit {

    public static class Produit {
        private long id;
        private String nom;

        public Produit(long id, String nom) {
            this.id = id;
            this.nom = nom;
        }

        @JsonProperty
        public long getId() {
            return id;
        }

        @JsonProperty
        public String getNom() {
            return nom;
        }

    }

    @GetMapping("/produit")
    public List<Produit> getListeProduits() {
        return Arrays.asList(
            new Produit(1, "PC1"),
            new Produit(2, "PC2"),
            new Produit(3, "Frigo")
        );
    }
}