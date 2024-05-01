// src/app/accueil/accueil.component.ts
import { Component } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { ProduitListComponent } from '../produit-list/produit-list.component';

@Component({
  selector: 'app-accueil',
  standalone: true,
  imports: [
    FormsModule, 
    RouterModule, 
    ProduitListComponent  // Importation de ProduitListComponent
  ],
  templateUrl: './accueil.component.html',
  styleUrls: ['./accueil.component.scss'] // Corriger 'styleUrl' en 'styleUrls'
})
export class AccueilComponent {
}
