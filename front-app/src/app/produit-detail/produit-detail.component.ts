import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { CommonModule, CurrencyPipe } from '@angular/common';
import { ProduitService } from '../services/produit.service';
import { Produit } from '../services/produit';
import { Location } from '@angular/common'; // Import Location service

@Component({
  selector: 'app-produit-detail',
  standalone: true,
  imports: [CommonModule, RouterModule, CurrencyPipe],
  templateUrl: './produit-detail.component.html',
  styleUrls: ['./produit-detail.component.scss']
})
export class ProduitDetailComponent implements OnInit {
  produit: Produit | undefined;

  constructor(
    private route: ActivatedRoute,
    private produitService: ProduitService,
    private location: Location
  ) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
      console.log('Route params:', params);  // Ce log montre ce que vous recevez réellement
      const id = +params['id'];
      console.log('Converted ID:', id);
      if (!isNaN(id) && id !== 0) {  // Ajout de la vérification pour éviter les ID nuls ou non numériques
        this.produitService.getProductById(id).subscribe(produit => {
          this.produit = produit;
        }, error => console.error('Error fetching product:', error));
      } else {
        console.error('Product ID is not a number or zero:', params['id']);
      }
    });
  }

  goBack(): void {
    this.location.back(); // Navigue à la page précédente
  }
}
