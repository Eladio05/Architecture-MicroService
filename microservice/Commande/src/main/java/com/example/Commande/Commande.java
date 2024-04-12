package com.example.Commande;
import jakarta.persistence.*;

@Entity
@Table(name = "Commande")
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Génère l'ID automatiquement
    @Column(name = "idcommande", nullable = false)
    private int idCommande;
    @Column(name = "nomproduit", nullable = false)
    private String idProduit;
    private Integer quantite;
    private String dateCommande;
    private Boolean paiement;

    public Commande(String id, String idProduit, Integer quantite, String dateCommande, Boolean paiement) {
        this.id = id;
        this.idProduit = idProduit;
        this.quantite = quantite;
        this.dateCommande = dateCommande;
        this.paiement = paiement;
    }

    public Commande() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(String idProduit) {
        this.idProduit = idProduit;
    }

    public String getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(String dateCommande) {
        this.dateCommande = dateCommande;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Boolean getPaiement() {
        return paiement;
    }

    public void setPaiement(Boolean paiement) {
        this.paiement = paiement;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "id='" + id + '\'' +
                ", idProduit='" + idProduit + '\'' +
                ", dateCommande=" + dateCommande +
                ", quantite=" + quantite +
                ", paiement=" + paiement +
                '}';
    }
}
