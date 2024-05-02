import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Produit } from './produit';  // Assure-toi de définir cette interface selon ton modèle

@Injectable({
  providedIn: 'root'
})
export class ProduitService {

  private baseUrl = 'http://localhost:9005/produit/Produits';  // Ajuste l'URL selon ton environnement

  constructor(private http: HttpClient) { }

  getProducts(): Observable<Produit[]> {
    return this.http.get<Produit[]>(`${this.baseUrl}`);
  }

  getProductById(id: number): Observable<Produit> {
    return this.http.get<Produit>(`${this.baseUrl}/${id}`);
  }
  

  
  
}
