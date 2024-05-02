// commande-list.component.ts
import { Component, OnInit } from '@angular/core';
import { CommandeService } from '../services/commande.service';
import { AuthService } from '../services/auth.service';
import { CommonModule } from '@angular/common';
import { RouterModule, Router } from '@angular/router';
import { Commande } from '../services/commande';

@Component({
  selector: 'app-commande-list',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './commande-list.component.html',
  styleUrls: ['./commande-list.component.scss']
})
export class CommandeListComponent implements OnInit {
  commandes: Commande[] = [];

  constructor(
    private commandeService: CommandeService,
    private authService: AuthService,
    private router: Router
  ) {}

  ngOnInit() {
    this.authService.currentUser.subscribe(user => {
      if (user && user.idClient) {
        this.commandeService.getAllCommandes().subscribe(
          allCommandes => {
            this.commandes = allCommandes.filter(c => c.idClient === user.idClient);
          },
          error => console.error('Erreur lors de la récupération des commandes', error)
        );
      } else {
        console.log("No user logged in.");
      }
    });
  }

  voirDetails(idCommande: number): void {
    this.router.navigate(['/commande-details', idCommande]);
  } 
}
