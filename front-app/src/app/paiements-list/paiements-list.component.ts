import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { PaiementService } from '../services/paiement.service';
import { AuthService } from '../services/auth.service';
import { CommandeService } from '../services/commande.service';
import { Paiement } from '../services/paiement';
import { Commande } from '../services/commande';
import { NavbarComponent } from '../navbar/navbar.component';

@Component({
  selector: 'app-paiements-list',
  standalone: true,
  imports: [
    CommonModule,  
    RouterModule,
    NavbarComponent  
  ],
  templateUrl: './paiements-list.component.html',
  styleUrls: ['./paiements-list.component.scss']
})
export class PaiementsListComponent implements OnInit {
  paiements: Paiement[] = [];
  commandes: Commande[] = [];

  constructor(
    private authService: AuthService,
    private commandeService: CommandeService,
    private paiementService: PaiementService
  ) {}

  ngOnInit() {
    this.authService.currentUser.subscribe(user => {
      if (user && user.idClient) {
        this.commandeService.getAllCommandes().subscribe(
          allCommandes => {
            this.commandes = allCommandes.filter(c => c.idClient === user.idClient);
            this.commandes.forEach(commande => {
              this.paiementService.getPaiementsByCommandeId(commande.idCommande!).subscribe(
                paiements => {
                  this.paiements = [...this.paiements, ...paiements];
                },
                error => console.error('Erreur lors de la récupération des paiements', error)
              );
            });
          },
          error => console.error('Erreur lors de la récupération des commandes', error)
        );
      }
    });
  }
}
