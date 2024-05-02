import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PaiementsListComponent } from './paiements-list.component';

describe('PaiementsListComponent', () => {
  let component: PaiementsListComponent;
  let fixture: ComponentFixture<PaiementsListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PaiementsListComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PaiementsListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
