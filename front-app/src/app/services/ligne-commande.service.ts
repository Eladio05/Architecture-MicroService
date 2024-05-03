import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { LigneCommande } from './ligne-commande';

@Injectable({
  providedIn: 'root'
})
export class LigneCommandeService {
  private ligneCommandeUrl = 'http://localhost:9005/commande/Lignecommandes';

  constructor(private http: HttpClient) {}

  getAllLignesCommande(): Observable<LigneCommande[]> {
    return this.http.get<LigneCommande[]>(this.ligneCommandeUrl);
  }

  addLigneCommande(ligneCommande: LigneCommande): Observable<LigneCommande> {
    return this.http.post<LigneCommande>(this.ligneCommandeUrl, ligneCommande);
  }
}
