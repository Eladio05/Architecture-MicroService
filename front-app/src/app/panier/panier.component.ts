import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterModule } from '@angular/router';
import { CurrencyPipe } from '@angular/common';
import { PanierService } from '../services/panier.service'; 
import { NavbarComponent } from '../navbar/navbar.component';
import { Produit } from '../services/produit';

interface PanierItem {
  product: Produit;
  quantity: number;
}

@Component({
  selector: 'app-panier',
  templateUrl: './panier.component.html',
  styleUrls: ['./panier.component.scss'],
  standalone: true,
  imports: [CommonModule, RouterModule, CurrencyPipe, NavbarComponent]
})
export class PanierComponent implements OnInit {
  consolidatedItems: PanierItem[] = [];
  isEmptyCart = false;  

  constructor(private panierService: PanierService, private router: Router) { }

  ngOnInit(): void {
    this.panierService.getItems().subscribe(items => {
      this.consolidateItems(items);
      this.isEmptyCart = items.length === 0; 
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

  removeItemFromCart(productId: number): void {
    this.panierService.removeItem(productId);
    this.panierService.getItems().subscribe(items => {
      this.consolidateItems(items);
      this.isEmptyCart = items.length === 0; 
    });
  }

  getTotalPrice(): number {
    return this.consolidatedItems.reduce((acc, cartItem) => acc + (cartItem.product.prix * cartItem.quantity), 0);
  }

  confirmCart(): void {
    if (this.isEmptyCart) {
      console.error('Le panier est vide');
    } else {
      console.log('Panier confirmé avec succès');
      this.router.navigate(['/paiement']);
    }
  }
}
