import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Paiement } from './paiement';  

@Injectable({
  providedIn: 'root'
})
export class PaiementService {
  private paiementsUrl = 'http://localhost:9005/paiement/Paiements';

  constructor(private http: HttpClient) {}

  getPaiementsByCommandeId(idCommande: number): Observable<Paiement[]> {
    return this.http.get<Paiement[]>(`${this.paiementsUrl}/com/${idCommande}`);
  }
}
