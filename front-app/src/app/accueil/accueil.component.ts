import { Component } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { ProduitListComponent } from '../produit-list/produit-list.component';
import { NavbarComponent } from '../navbar/navbar.component';

@Component({
  selector: 'app-accueil',
  standalone: true,
  imports: [
    FormsModule, 
    RouterModule, 
    ProduitListComponent,
    NavbarComponent
  ],
  templateUrl: './accueil.component.html',
  styleUrls: ['./accueil.component.scss'] 
})
export class AccueilComponent {
}
