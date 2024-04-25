import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.scss'
})

export class RegisterComponent {
  user = { nom: null, prenom: null, adresse: null, identifiant: null, motdepasse: null };

  constructor(private authService: AuthService, private router: Router) {}

  onSubmit() {
    if (!this.user.nom || !this.user.prenom || !this.user.adresse || !this.user.identifiant || !this.user.motdepasse) {
      alert("Veuillez remplir tous les champs afin de vous inscrire.");
      return; 
    }

    this.authService.register(this.user).subscribe(
      response => {
        console.log('Inscription réussie', response);
        this.router.navigate(['/login']); 
      },
      error => {
        console.error("Erreur d'inscription", error);
        console.log(error.error); 
        alert("Erreur lors de l'inscription. Veuillez réessayer."); 
      }
    );
  }
}