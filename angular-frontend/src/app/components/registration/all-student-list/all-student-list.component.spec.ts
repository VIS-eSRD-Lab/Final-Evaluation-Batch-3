import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllStudentListComponent } from './all-student-list.component';

describe('AllStudentListComponent', () => {
  let component: AllStudentListComponent;
  let fixture: ComponentFixture<AllStudentListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AllStudentListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AllStudentListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
