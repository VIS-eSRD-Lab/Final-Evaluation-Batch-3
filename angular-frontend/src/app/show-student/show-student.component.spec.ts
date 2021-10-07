import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowStudentComponent } from './show-student.component';

describe('ShowStudentComponent', () => {
  let component: ShowStudentComponent;
  let fixture: ComponentFixture<ShowStudentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShowStudentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowStudentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
