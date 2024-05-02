// commande-details.component.ts
import { NgModule, LOCALE_ID } from '@angular/core';
import { CommonModule, CurrencyPipe } from '@angular/common';
import { RouterModule } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { LigneCommandeService } from '../services/ligne-commande.service';
import { ProduitService } from '../services/produit.service';
import { registerLocaleData } from '@angular/common';
import localeFr from '@angular/common/locales/fr';

registerLocaleData(localeFr);

@Component({
  selector: 'app-commande-details',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './commande-details.component.html',
  styleUrls: ['./commande-details.component.scss'],
  providers: [{ provide: LOCALE_ID, useValue: 'fr' }]  // Assurez-vous de définir la locale correctement
})

export class CommandeDetailsComponent implements OnInit {
  lignesCommande: any[] = [];
  idCommande!: number;

  constructor(
    private ligneCommandeService: LigneCommandeService,
    private produitService: ProduitService,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.idCommande = +params['idCommande'];
      this.loadLignesCommande();
    });
  }

  loadLignesCommande() {
    this.ligneCommandeService.getAllLignesCommande().subscribe(
      data => {
        const filteredLignes = data.filter(ligne => ligne.idCommande === this.idCommande);
        filteredLignes.forEach(ligne => {
          this.produitService.getProductById(ligne.idProduit).subscribe(
            produit => {
              this.lignesCommande.push({ ...produit, quantite: ligne.quantite });
            },
            error => console.error('Error loading product details', error)
          );
        });
      },
      error => console.error('Error loading lignes de commande', error)
    );
  }

  getTotalPrix(): number {
    let total = 0;
    this.lignesCommande.forEach(item => {
      total += item.prix * item.quantite;
    });
    return total;
  }
  
}
