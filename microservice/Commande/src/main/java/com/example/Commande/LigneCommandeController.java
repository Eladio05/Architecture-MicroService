package com.example.Commande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Lignecommandes")
public class LigneCommandeController {

    @Autowired
    private LigneCommandeBDD ligneCommandeBDD;

    @PostMapping
    public ResponseEntity<LigneCommande> ajouterLigneCommande(@RequestBody LigneCommande ligneCommande) {
        LigneCommande nouvelleLigne = ligneCommandeBDD.save(ligneCommande);
        return new ResponseEntity<>(nouvelleLigne, HttpStatus.CREATED);
    }

    @GetMapping
    public List<LigneCommande> getAllLignesCommande() {
        return ligneCommandeBDD.findAll();
    }

    @GetMapping("/{idCommande}/{idProduit}")
    public ResponseEntity<LigneCommande> getLigneCommande(@PathVariable int idCommande, @PathVariable int idProduit) {
        Optional<LigneCommande> ligneCommande = ligneCommandeBDD.findById(new LigneCommandeId(idCommande, idProduit));
        return ligneCommande
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{idCommande}/{idProduit}")
    public ResponseEntity<Void> deleteLigneCommande(@PathVariable int idCommande, @PathVariable int idProduit) {
        LigneCommandeId id = new LigneCommandeId(idCommande, idProduit);
        if (ligneCommandeBDD.existsById(id)) {
            ligneCommandeBDD.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
