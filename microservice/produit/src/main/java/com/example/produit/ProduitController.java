package com.example.produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Produits") // Ajout d'un RequestMapping pour centraliser le mapping de base
public class ProduitController {

    @Autowired
    private ProduitBDD produitBDD;

    // Récupérer tous les produits
    @GetMapping
    public List<Produit> listeProduits() {
        return produitBDD.findAll();
    }

    // Récupérer un produit par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Produit> afficherProduit(@PathVariable int id) {
        Optional<Produit> produit = produitBDD.findById(id);
        return produit.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Supprimer un produit par son ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerProduit(@PathVariable int id) {
        if (produitBDD.existsById(id)) {
            produitBDD.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Ajouter un produit
    @PostMapping
    public ResponseEntity<Produit> ajouterProduit(@RequestBody Produit produit) {
        Produit nouveauProduit = produitBDD.save(produit);
        return new ResponseEntity<>(nouveauProduit, HttpStatus.CREATED);
    }

    // Supprimer tous les produits
    @DeleteMapping
    public ResponseEntity<Void> supprimerTousProduits() {
        produitBDD.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
