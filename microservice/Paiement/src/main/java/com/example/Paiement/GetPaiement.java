package com.example.Paiement;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Arrays;

@RestController
public class GetPaiement {

    public static class Paiement {
        private long id;
        private double montant;

        public Paiement(long id, double montant) {
            this.id = id;
            this.montant = montant;
        }

        @JsonProperty
        public long getId() {
            return id;
        }

        @JsonProperty
        public double getMontant() {
            return montant;
        }

    }

    @GetMapping("/paiements")
    public List<Paiement> getListePaiements() {
        return Arrays.asList(
            new Paiement(1, 99.99),
            new Paiement(2, 49.99),
            new Paiement(3, 199.99)
        );
    }
}
