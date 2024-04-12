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
    private ProduitBDD produitBDD;

    @GetMapping(value = "/Produits")
    public List<Produit> listeProduits() {
        return produitBDD.findAll();
    }

    @GetMapping(value = "/Produits/{id}")
    public ResponseEntity<Produit> afficherProduit(@PathVariable String id) {
        Optional<Produit> produit = produitBDD.findById(id);
        return produit.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping(value = "/Produits/{id}")
    public ResponseEntity<Void> supprimerProduit(@PathVariable String id) {
        if (produitBDD.existsById(id)) {
            produitBDD.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/Produits")
    public ResponseEntity<Produit> ajouterProduit(@RequestBody Produit produit) {
        Produit nouveauProduit = produitBDD.save(produit);
        return new ResponseEntity<>(nouveauProduit, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/Produits")
    public ResponseEntity<Void> supprimerTousProduits() {
        produitBDD.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
