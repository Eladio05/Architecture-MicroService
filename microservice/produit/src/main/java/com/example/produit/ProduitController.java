package com.example.produit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProduitController {

    @Autowired
    private ProduitBDD produitBDD; // Assurez-vous que ceci correspond au nouveau nom de votre repository

    // Affiche la liste de tous les produits disponibles
    @GetMapping(value = "/Produit")
    public List<Produit> listeProduits() {
        return produitBDD.findAll();
    }

    @GetMapping(value = "/Produit/{id}")
    public ResponseEntity<Produit> afficherProduit(@PathVariable String id) { // Changez le type de id en String
        Optional<Produit> produit = produitBDD.findById(id);
        return produit.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping(value = "/Produit/{id}")
    public ResponseEntity<Void> supprimerProduit(@PathVariable String id) { // Changez le type de id en String
        if (produitBDD.existsById(id)) {
            produitBDD.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/Produit")
    public ResponseEntity<Produit> ajouterProduit(@RequestBody Produit produit) {
        Produit nouveauProduit = produitBDD.save(produit);
        return new ResponseEntity<>(nouveauProduit, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/Produit")
    public ResponseEntity<Void> supprimerTousProduits() {
        produitBDD.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
