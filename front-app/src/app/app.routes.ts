import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { AccueilComponent } from './accueil/accueil.component';

export const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent, title: "Connexion"},
  { path: 'register', component: RegisterComponent, title: "Inscription"},
  { path: 'accueil', component: AccueilComponent, title: "Accueil"},

];
