import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegSlipComponent } from './reg-slip.component';

describe('RegSlipComponent', () => {
  let component: RegSlipComponent;
  let fixture: ComponentFixture<RegSlipComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegSlipComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RegSlipComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
