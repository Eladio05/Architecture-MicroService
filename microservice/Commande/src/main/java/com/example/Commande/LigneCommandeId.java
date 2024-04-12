package com.example.Commande;

import java.io.Serializable;
import java.util.Objects;

public class LigneCommandeId implements Serializable {
    private int idCommande;
    private int idProduit;

    public LigneCommandeId(int idCommande, int idProduit) {
        this.idCommande = idCommande;
        this.idProduit = idProduit;
    }

    public LigneCommandeId(){

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LigneCommandeId that = (LigneCommandeId) o;
        return idCommande == that.idCommande && idProduit == that.idProduit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCommande, idProduit);
    }
}
