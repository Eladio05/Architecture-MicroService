import { Component, OnInit } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { NavbarComponent } from '../navbar/navbar.component';
import { CommandeService } from '../services/commande.service';
import { AuthService } from '../services/auth.service';
import { PanierService } from '../services/panier.service';
import { Commande } from '../services/commande';
import { LigneCommandeService } from '../services/ligne-commande.service';
import { Produit } from '../services/produit';

interface PanierItem {
  product: Produit;
  quantity: number;
}

@Component({
  selector: 'app-paiement',
  templateUrl: './paiement.component.html',
  styleUrls: ['./paiement.component.scss'],
  standalone: true,
  imports: [CommonModule, RouterModule, FormsModule, NavbarComponent]
})
export class PaiementComponent implements OnInit {
  cardNumber: string = '';
  expiryDate: string = '';
  cvc: string = '';
  consolidatedItems: PanierItem[] = [];
  showConfirmation = false;


  constructor(
    private router: Router,
    private commandeService: CommandeService,
    private authService: AuthService,
    private panierService: PanierService,
    private ligneCommandeService: LigneCommandeService
  ) {}

  ngOnInit(): void {
    this.panierService.getItems().subscribe(items => {
      this.consolidateItems(items);
    });
  }

  consolidateItems(items: Produit[]): void {
    const productMap = new Map<number, PanierItem>();
    items.forEach(item => {
      let cartItem = productMap.get(item.id);
      if (cartItem) {
        cartItem.quantity += 1;
      } else {
        productMap.set(item.id, { product: item, quantity: 1 });
      }
    });
    this.consolidatedItems = Array.from(productMap.values());
  }

  processPayment(): void {
    if (this.validateCardNumber() && this.validateExpiryDate() && this.validateCVC()) {
      this.authService.currentUser.subscribe(user => {
        if (user && user.idClient) {
          const newCommande: Commande = {
            idClient: user.idClient,
            dateCommande: new Date().toISOString().slice(0, 10)
          };
          this.commandeService.createCommande(newCommande).subscribe(commande => {
            this.consolidatedItems.forEach(item => {
              this.ligneCommandeService.addLigneCommande({
                idCommande: commande.idCommande!,
                idProduit: item.product.id,
                quantite: item.quantity
              }).subscribe();
            });
            this.panierService.resetPanier();
            this.showConfirmation = true;
            setTimeout(() => {
              this.showConfirmation = false;
              this.router.navigate(['/accueil']); 
            }, 5000);
          });
        } else {
          console.error('Aucun utilisateur connecté');
        }
      });
    } else {
      console.error('Validation Error: Veuillez vérifier les données de votre carte.');
    }
  }

  validateCardNumber(): boolean {
    return this.cardNumber.replace(/\s+/g, '').length === 16;
  }

  validateExpiryDate(): boolean {
    return /^(0[1-9]|1[0-2])\/\d{2}$/.test(this.expiryDate);
  }

  validateCVC(): boolean {
    return /^\d{3}$/.test(this.cvc);
  }
}
