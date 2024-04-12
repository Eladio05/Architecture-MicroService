package com.example.Commande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CommandeController {
    @Autowired
    private CommandeBDD commandeBDD;

    // Affiche la liste de toutes les commandes disponibles
    @GetMapping(value = "/Commandes")
    public List<Commande> listeCommandes() {
        return commandeBDD.findAll();
    }

    // Affiche une commande spécifique par son ID
    @GetMapping(value = "/Commandes/{id}")
    public ResponseEntity<Commande> afficherCommande(@PathVariable String id) {
        Optional<Commande> commande = commandeBDD.findById(id);
        return commande.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Ajouter une nouvelle commande
    @PostMapping(value = "/Commandes")
    public ResponseEntity<Commande> ajouterCommande(@RequestBody Commande commande) {
        Commande nouvelleCommande = commandeBDD.save(commande);
        return new ResponseEntity<>(nouvelleCommande, HttpStatus.CREATED);
    }

}
