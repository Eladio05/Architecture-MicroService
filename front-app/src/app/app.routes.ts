import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { AccueilComponent } from './accueil/accueil.component';
import { ProduitDetailComponent } from './produit-detail/produit-detail.component';
import { CommandeListComponent } from './commande-list/commande-list.component';
import { CommandeDetailsComponent } from './commande-details/commande-details.component';
import { PaiementsListComponent } from './paiements-list/paiements-list.component';
import { PanierComponent } from './panier/panier.component';


export const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent, title: "Connexion"},
  { path: 'register', component: RegisterComponent, title: "Inscription"},
  { path: 'accueil', component: AccueilComponent, title: "Accueil"},
  { path: 'produit/:id', component: ProduitDetailComponent},
  { path: 'commandes', component: CommandeListComponent, title:"Commande"},
  { path: 'commande-details/:idCommande', component: CommandeDetailsComponent, title:"LigneCommande" },
  { path: 'paiements', component: PaiementsListComponent, title:"Paiements" },
  { path: 'panier', component: PanierComponent, pathMatch: 'full' }

];
