package com.example.produit;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "produit")
public class Produit {
    @Id
    private int id;
    private String nomProduit;
    private double prix;


    public Produit() {
    }

    public Produit(int id, String nomProduit, double prix) {
        this.id = id;
        this.nomProduit = nomProduit;
        this.prix = prix;
    }

    // Getters et setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                "id='" + id + '\'' +
                ", nomProduit='" + nomProduit + '\'' +
                ", prix=" + prix +
                '}';
    }
}
