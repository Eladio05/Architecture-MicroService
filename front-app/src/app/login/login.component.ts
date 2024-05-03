import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { RouterModule } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule, RouterModule, CommonModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  user = { identifiant: '', motdepasse: '' };
  loginError = false; 

  constructor(private authService: AuthService, private router: Router) {}

  onSubmit() {
    this.authService.login(this.user).subscribe({
      next: (response) => {
        console.log('Connexion réussie', response);
        this.router.navigate(['/accueil']);
      },
      error: (error) => {
        console.error('Erreur de connexion', error);
        this.loginError = true; 
      }
    });
  }
}
