import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common'; // Ajout pour l'utilisation des directives communes
import { ProduitService } from '../services/produit.service';
import { Produit } from '../services/produit';

@Component({
  selector: 'app-produit-list',
  standalone: true,
  imports: [
    CommonModule  // Permet l'utilisation de NgFor, NgIf, etc.
  ],
  templateUrl: './produit-list.component.html',
  styleUrls: ['./produit-list.component.scss']
})
export class ProduitListComponent implements OnInit {
  products: Produit[] = [];

  constructor(private produitService: ProduitService) { }

  ngOnInit() {
    this.produitService.getProducts().subscribe(produits => {
      this.products = produits;
    });
  }
}
