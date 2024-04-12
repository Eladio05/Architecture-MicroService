package com.example.Paiement;
import jakarta.persistence.*;

@Entity
@Table(name = "Paiement")
public class Paiement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpaiement", nullable = false)
    private int idPaiement;
    @Column(name = "idcommande", nullable = false)
    private int idCommande;
    @Column(name = "montant", nullable = false)
    private float montant;

    public Paiement(int idPaiement, int idCommande, float montant) {
        this.idPaiement = idPaiement;
        this.idCommande = idCommande;
        this.montant = montant;
    }

    public Paiement() {

    }

    public int getIdPaiement() {
        return idPaiement;
    }

    public void setIdPaiement(int idPaiement) {
        this.idPaiement = idPaiement;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }
}

