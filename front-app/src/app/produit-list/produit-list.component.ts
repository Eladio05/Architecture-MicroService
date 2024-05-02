import { CommonModule, CurrencyPipe } from '@angular/common';
import { RouterModule } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { ProduitService } from '../services/produit.service';
import { Produit } from '../services/produit';

@Component({
  selector: 'app-produit-list',
  standalone: true,
  imports: [
    CommonModule,
    RouterModule,  // Ajoutez RouterModule pour la navigation
    CurrencyPipe
  ],
  templateUrl: './produit-list.component.html',
  styleUrls: ['./produit-list.component.scss']
})
export class ProduitListComponent implements OnInit {
  products: Produit[] = [];

  constructor(private produitService: ProduitService) { }

  // Dans produit-list.component.ts
  ngOnInit() {
    this.produitService.getProducts().subscribe(produits => {
      console.log('Products:', produits);  // Ajoutez ce log pour vérifier les données
      this.products = produits;
    });
  }

}
