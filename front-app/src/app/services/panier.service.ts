import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { Produit } from './produit';

@Injectable({
  providedIn: 'root'
})
export class PanierService {
  private itemsInCartSubject: BehaviorSubject<Produit[]> = new BehaviorSubject<Produit[]>([]);
  private itemsInCart: Produit[] = [];

  constructor() {
    this.itemsInCartSubject.subscribe(_ => this.itemsInCart = _);
  }

  public addToCart(item: Produit) {
    this.itemsInCartSubject.next([...this.itemsInCart, item]);
  }

  public getItems(): Observable<Produit[]> {
    return this.itemsInCartSubject.asObservable();
  }

  public getItemsCount(): number {
    return this.itemsInCart.length;
  }

  public getProductIds(): number[] {
    return this.itemsInCart.map(item => item.id);
  }
}
