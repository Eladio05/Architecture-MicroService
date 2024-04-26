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

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "prix", nullable = false)
    private double prix;

    @Column(name = "urlimage", nullable = false)
    private String urlImage;

    public Produit() {
    }

    public Produit(int idProduit, String nomProduit, String description, double prix, String urlImage) {
        this.idProduit = idProduit;
        this.nomProduit = nomProduit;
        this.description = description;
        this.prix = prix;
        this.urlImage = urlImage;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "idProduit=" + idProduit +
                ", nomProduit='" + nomProduit + '\'' +
                ", description='" + description + '\'' +
                ", prix=" + prix +
                ", urlImage='" + urlImage + '\'' +
                '}';
    }
}
