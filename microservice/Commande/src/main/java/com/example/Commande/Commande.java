package com.example.Commande;
import jakarta.persistence.*;

@Entity
@Table(name = "Commande")
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Génère l'ID automatiquement
    @Column(name = "idcommande", nullable = false)
    private int idCommande;
    @Column(name = "idclient", nullable = false)
    private int idClient;
    @Column(name = "datecommande", nullable = false)
    private String dateCommande;

    public Commande(int idCommande, int idClient, String dateCommande) {
        this.idCommande = idCommande;
        this.idClient = idClient;
        this.dateCommande = dateCommande;
    }

    public Commande(){
    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(String dateCommande) {
        this.dateCommande = dateCommande;
    }
}
