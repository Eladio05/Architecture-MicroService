import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'http://localhost:9005'; 

  constructor(private http: HttpClient) { }

  login(credentials: { identifiant: string, motdepasse: string }): Observable<any> {
    console.log('Sending these credentials:', credentials);
    return this.http.post(`${this.apiUrl}/client/Clients/auth`, credentials);
  }


  register(user: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/client/Clients`, user);
  }
}
