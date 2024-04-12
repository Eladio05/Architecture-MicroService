package com.example.Paiement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Paiements")
public class PaiementController {
    @Autowired
    private PaiementBDD paiementBDD;
    
    @GetMapping
    public List<Paiement> listePaiement(){
        return paiementBDD.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paiement> afficherPaiement(@PathVariable int id) {
        Optional<Paiement> paiement = paiementBDD.findById(id);
        return paiement.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerPaiement(@PathVariable int id) {
        if (paiementBDD.existsById(id)) {
            paiementBDD.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Paiement> ajouterPaiement(@RequestBody Paiement paiement) {
        Paiement nouveauPaiement = paiementBDD.save(paiement);
        return new ResponseEntity<>(nouveauPaiement, HttpStatus.CREATED);
    }
}
