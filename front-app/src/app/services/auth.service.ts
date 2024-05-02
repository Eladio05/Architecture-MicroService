import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';
import { tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'http://localhost:9005'; 
  private currentUserSubject = new BehaviorSubject<any>(null);

  constructor(private http: HttpClient) {
    this.loadUserFromStorage();
  }

  get currentUser() {
    return this.currentUserSubject.asObservable();
  }

  private loadUserFromStorage() {
    const userData = localStorage.getItem('currentUser');
    if (userData) {
      this.currentUserSubject.next(JSON.parse(userData));
    }
  }

  login(credentials: { identifiant: string, motdepasse: string }): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/client/Clients/auth`, credentials).pipe(
      tap(response => {
        if (response && response.idClient) { // Assurez-vous que votre backend renvoie cette propriété
          localStorage.setItem('currentUser', JSON.stringify(response));
          this.currentUserSubject.next(response);
        }
      })
    );
  }

  register(user: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/client/Clients`, user);
  }

  logout() {
    localStorage.removeItem('currentUser');
    this.currentUserSubject.next(null);
  }

  getUserId(): number | null {
    return this.currentUserSubject.value ? this.currentUserSubject.value.idClient : null; // Utilisez idClient ici
  }
}
