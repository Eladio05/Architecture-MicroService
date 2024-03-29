package com.example.Commande;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Arrays;

@RestController
public class GetCommande {

    public static class Materiel {
        private String nom;
        private int quantite;

        public Materiel(String nom, int quantite) {
            this.nom = nom;
            this.quantite = quantite;
        }

        @JsonProperty
        public String getNom() {
            return nom;
        }

        @JsonProperty
        public int getQuantite() {
            return quantite;
        }
    }

    public static class Commande {
        private long id;
        private List<Materiel> listeMateriel;

        public Commande(long id, List<Materiel> listeMateriel) {
            this.id = id;
            this.listeMateriel = listeMateriel;
        }

        @JsonProperty
        public long getId() {
            return id;
        }

        @JsonProperty
        public List<Materiel> getListeMateriel() {
            return listeMateriel;
        }
    }

    @GetMapping("/commandes")
    public List<Commande> getListeCommandes() {
        return Arrays.asList(
            new Commande(1, Arrays.asList(new Materiel("Clavier", 10), new Materiel("Souris", 15))),
            new Commande(2, Arrays.asList(new Materiel("Écran", 5), new Materiel("Câble HDMI", 20))),
            new Commande(3, Arrays.asList(new Materiel("Disque Dur", 7), new Materiel("RAM", 12)))
        );
    }
}
