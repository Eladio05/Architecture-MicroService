package com.example.Commande;
import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Lignecommande")
@IdClass(LigneCommandeId.class)
public class LigneCommande{
    @Id
    @Column(name = "idcommande", nullable = false)
    private int idCommande;
    @Id
    @Column(name = "idproduit", nullable = false)
    private int idProduit;
    @Column(name = "quantite", nullable = false)
    private int quantite;

    public LigneCommande(int idCommande, int idProduit, int quantite) {
        this.idCommande = idCommande;
        this.idProduit = idProduit;
        this.quantite = quantite;
    }

    public LigneCommande(){

    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}

