import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { PanierService } from '../services/panier.service';


@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss'],
  standalone: true,
  imports: [
    CommonModule,
    RouterModule,
  ]
})
export class NavbarComponent {
  itemCount: number = 0;

  constructor(private authService: AuthService, private router: Router, private panierService: PanierService) { 
  }

  ngOnInit(): void {
    this.panierService.getItems().subscribe(items => {
      this.itemCount = items.length;
    });
  }

  logout() {
    this.panierService.resetPanier();
    this.authService.logout();
    this.router.navigate(['/login']); 
  }

}
