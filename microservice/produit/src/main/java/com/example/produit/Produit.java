package com.example.produit;
import jakarta.persistence.*;

@Entity
@Table(name = "Produit")
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Génère l'ID automatiquement
    @Column(name = "idproduit", nullable = false)
    private int idProduit;

    @Column(name = "nomproduit", nullable = false)
    private String nomProduit;


    @Column(name = "prix", nullable = false)
    private double prix;

    public Produit() {
    }

    public Produit(int idProduit, String nomProduit, double prix) {
        this.idProduit = idProduit;
        this.nomProduit = nomProduit;
        this.prix = prix;
    }

    // Getters et setters

    public int getId() {
        return idProduit;
    }

    public void setId(int idProduit) {
        this.idProduit = idProduit;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "idProduit=" + idProduit +
                ", nomProduit='" + nomProduit + '\'' +
                ", prix=" + prix +
                '}';
    }
}
