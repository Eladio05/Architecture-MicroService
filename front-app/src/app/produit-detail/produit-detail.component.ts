import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { CommonModule, CurrencyPipe } from '@angular/common';
import { ProduitService } from '../services/produit.service';
import { Produit } from '../services/produit';
import { Location } from '@angular/common'; 
import { NavbarComponent } from '../navbar/navbar.component';
import { PanierService } from '../services/panier.service'; 

@Component({
  selector: 'app-produit-detail',
  standalone: true,
  imports: [CommonModule, RouterModule, CurrencyPipe, NavbarComponent],
  templateUrl: './produit-detail.component.html',
  styleUrls: ['./produit-detail.component.scss']
})
export class ProduitDetailComponent implements OnInit {
  produit: Produit | undefined;
  showMessage = false;

  constructor(
    private route: ActivatedRoute,
    private produitService: ProduitService,
    private location: Location,
    private panierService: PanierService
  ) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
      const id = +params['id'];
      if (!isNaN(id) && id !== 0) {  
        this.produitService.getProductById(id).subscribe(produit => {
          this.produit = produit;
        }, error => console.error('Error fetching product:', error));
      }
    });
  }

  addToCart(produit: Produit | undefined): void {
    if (produit) {
      this.panierService.addToCart(produit);
      this.showMessage = true;
      setTimeout(() => {
        this.showMessage = false;
      }, 3000); 
    }
  }

  goBack(): void {
    this.location.back(); 
  }
}
